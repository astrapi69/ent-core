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

import java.util.concurrent.atomic.AtomicLong;

import lombok.NonNull;
import io.github.astrapi69.data.identifiable.IdGenerator;

/**
 * The class {@link LongIdGenerator} is an implementation of {@link IdGenerator} interface with id
 * type of {@link Long} object
 */
public class LongIdGenerator implements IdGenerator<Long>
{

	/**
	 * The default instance with an initial value of 0
	 */
	private static final LongIdGenerator instance = new LongIdGenerator(0L);

	/**
	 * The atomic id.
	 */
	private final AtomicLong atomicId;

	/**
	 * Instantiates a new {@link LongIdGenerator}
	 * 
	 * @param initialValue
	 *            the initial value for the generator
	 */
	private LongIdGenerator(final @NonNull Long initialValue)
	{
		atomicId = new AtomicLong(initialValue);
	}

	/**
	 * Factory method for create a new custom {@link LongIdGenerator} with an initial value
	 *
	 * @param initialValue
	 *            the initial value for the generator
	 */
	public static LongIdGenerator of(final @NonNull Long initialValue)
	{
		return new LongIdGenerator(initialValue);
	}

	/**
	 * Gets the single instance of {@link LongIdGenerator} object
	 *
	 * @return single instance of {@link LongIdGenerator} object
	 */
	public static LongIdGenerator getInstance()
	{
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getNextId()
	{
		return atomicId.getAndIncrement();
	}
}
