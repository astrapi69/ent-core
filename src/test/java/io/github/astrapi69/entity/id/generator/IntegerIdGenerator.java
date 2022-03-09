package io.github.astrapi69.entity.id.generator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import lombok.NonNull;

public class IntegerIdGenerator implements IdGenerator<Integer>
{

	/**
	 * The default instance with an initial value of 0
	 */
	private static final IntegerIdGenerator instance = new IntegerIdGenerator(0);
	/**
	 * The atomic id.
	 */
	private final AtomicInteger atomicId;

	/**
	 * Instantiates a new {@link IntegerIdGenerator}
	 *
	 * @param startFromId
	 *            the initial value for the generator
	 */
	private IntegerIdGenerator(final @NonNull Integer startFromId)
	{
		atomicId = new AtomicInteger(startFromId);
	}

	/**
	 * Factory method for create a new custom {@link IntegerIdGenerator} with an initial value
	 *
	 * @param startFromId
	 *            the initial value for the generator
	 */
	public static IntegerIdGenerator of(final @NonNull Integer startFromId)
	{
		return new IntegerIdGenerator(startFromId);
	}

	/**
	 * Gets the single instance of SystemTimeIdGenerator.
	 *
	 * @return single instance of SystemTimeIdGenerator
	 */
	public static IntegerIdGenerator getInstance()
	{
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getNextId()
	{
		Integer nextId = atomicId.getAndIncrement();
		return nextId;
	}
}
