package io.github.astrapi69.entity.id.generator;

import java.util.concurrent.atomic.AtomicLong;

import lombok.NonNull;

/**
 * The class {@link LongIdGenerator} is an implementation of {@link io.github.astrapi69.entity.id.generator.IdGenerator}
 * interface with id type of {@link Long} object
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
	 * @param startFromId
	 *            the initial value for the generator
	 */
	private LongIdGenerator(final @NonNull Long startFromId)
	{
		atomicId = new AtomicLong(startFromId);
	}

	/**
	 * Factory method for create a new custom {@link LongIdGenerator} with an initial value
	 *
	 * @param startFromId
	 *            the initial value for the generator
	 */
	public static LongIdGenerator of(final @NonNull Long startFromId)
	{
		return new LongIdGenerator(startFromId);
	}

	/**
	 * Gets the single instance of SystemTimeIdGenerator.
	 *
	 * @return single instance of SystemTimeIdGenerator
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
		// long nextId =
		long nextId = atomicId.getAndIncrement();
		if (nextId < 0)
		{
			nextId *= -1;
		}
		return nextId;
	}
}
