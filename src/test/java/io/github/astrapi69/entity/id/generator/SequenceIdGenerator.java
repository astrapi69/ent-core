/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.entity.id.generator;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.prefs.Preferences;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import io.github.astrapi69.data.identifiable.IdGenerator;

/**
 * Example of stackoverflow.com see
 * 'https://stackoverflow.com/questions/22416826/sequence-generator-in-java-for-unique-id'
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class SequenceIdGenerator implements IdGenerator<Long>
{

	private static final Preferences PREFERENCES = Preferences
		.userNodeForPackage(SequenceIdGenerator.class);
	private static final AtomicLong ATOMIC_ID_COUNTER = new AtomicLong(Integer.parseInt(PREFERENCES
		.get(SequenceValue.DEFAULT_SEQUENCE_ID_KEY, SequenceValue.DEFAULT_SEQUENCE_INITIAL_VALUE)));
	private static final Map<Long, SoftReference<SequenceIdGenerator>> GENERATORS = new ConcurrentHashMap<>();
	private static final SequenceIdGenerator DEFAULT_GENERATOR = new SequenceIdGenerator(0L,
		Long.parseLong(PREFERENCES.get(SequenceValue.DEFAULT_SEQUENCE_PREFIX + "0",
			SequenceValue.DEFAULT_SEQUENCE_INITIAL_VALUE)));

	static
	{
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			GENERATORS.values().stream().map(SoftReference::get)
				.filter(seq -> seq != null && seq.isPersistOnExit())
				.forEach(SequenceIdGenerator::persist);
			if (DEFAULT_GENERATOR.isPersistOnExit())
			{
				DEFAULT_GENERATOR.persist();
			}
			PREFERENCES.put(SequenceValue.DEFAULT_SEQUENCE_ID_KEY, ATOMIC_ID_COUNTER.toString());
		}));
	}

	{
		persistOnExit = new AtomicBoolean(false);
	}

	long sequenceId;
	AtomicLong atomicIdCounter;
	AtomicBoolean persistOnExit;

	private SequenceIdGenerator(long sequenceId, long initialValue)
	{
		this.sequenceId = sequenceId;
		atomicIdCounter = new AtomicLong(initialValue);
	}

	public long getCurrentId()
	{
		return atomicIdCounter.get();
	}

	public long getSequenceId()
	{
		return sequenceId;
	}

	public boolean isPersistOnExit()
	{
		return persistOnExit.get();
	}

	public void setPersistOnExit(boolean persistOnExit)
	{
		this.persistOnExit.set(persistOnExit);
	}

	public void persist()
	{
		PREFERENCES.put(SequenceValue.DEFAULT_SEQUENCE_PREFIX + sequenceId,
			atomicIdCounter.toString());
	}

	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		GENERATORS.remove(sequenceId);
		if (persistOnExit.get())
		{
			persist();
		}
	}

	@Override
	public int hashCode()
	{
		return Long.hashCode(sequenceId);
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj == this || obj != null && obj instanceof SequenceIdGenerator
			&& sequenceId == ((SequenceIdGenerator)obj).sequenceId;
	}

	@Override
	public String toString()
	{
		return "{" + "sequence=" + sequenceId + ", counter=" + atomicIdCounter + '}';
	}

	public static SequenceIdGenerator getDefault()
	{
		return DEFAULT_GENERATOR;
	}

	public static SequenceIdGenerator get(long sequenceId)
	{
		if (sequenceId < 0)
		{
			throw new IllegalArgumentException("(sequenceId = " + sequenceId + ") < 0");
		}
		if (sequenceId == 0)
		{
			return DEFAULT_GENERATOR;
		}
		SoftReference<SequenceIdGenerator> r = GENERATORS.computeIfAbsent(sequenceId, sid -> {
			try
			{
				return new SoftReference<>(new SequenceIdGenerator(sid, Long.parseLong(
					PREFERENCES.get(SequenceValue.DEFAULT_SEQUENCE_PREFIX + sid, null))));
			}
			catch (Throwable t)
			{
				return null;
			}
		});
		return r == null ? null : r.get();
	}

	public static SequenceIdGenerator newSequenceIdGenerator()
	{
		return newSequenceIdGenerator(1);
	}

	public static SequenceIdGenerator newSequenceIdGenerator(long initialValue)
	{
		long sequenceId = ATOMIC_ID_COUNTER.getAndIncrement();
		SequenceIdGenerator sequenceIdGenerator = new SequenceIdGenerator(sequenceId,
			Long.parseLong(PREFERENCES.get(SequenceValue.DEFAULT_SEQUENCE_PREFIX + sequenceId,
				"" + initialValue)));
		GENERATORS.put(sequenceId, new SoftReference<>(sequenceIdGenerator));
		return sequenceIdGenerator;
	}

	@Override
	public Long getNextId()
	{
		return atomicIdCounter.getAndIncrement();
	}

}
