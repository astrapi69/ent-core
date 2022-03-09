package io.github.astrapi69.entity.id.generator;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import lombok.NonNull;

/**
 * The class {@link BigIntegerIdGenerator} is an implementation of {@link IdGenerator}
 * interface with id type of {@link Long} object
 */
public class BigIntegerIdGenerator implements IdGenerator<BigInteger>
{

	/**
	 * The default instance with an initial value of 0
	 */
	private static final BigIntegerIdGenerator instance = new BigIntegerIdGenerator(BigInteger.ZERO);

	/**
	 * The atomic id.
	 */
	private final AtomicBigInteger atomicId;

	/**
	 * Instantiates a new {@link BigIntegerIdGenerator}
	 *
	 * @param startFromId
	 *            the initial value for the generator
	 */
	private BigIntegerIdGenerator(final @NonNull BigInteger startFromId)
	{
		atomicId = new AtomicBigInteger(startFromId);
	}

	/**
	 * Factory method for create a new custom {@link BigIntegerIdGenerator} with an initial value
	 *
	 * @param startFromId
	 *            the initial value for the generator
	 */
	public static BigIntegerIdGenerator of(final @NonNull BigInteger startFromId)
	{
		return new BigIntegerIdGenerator(startFromId);
	}

	/**
	 * Gets the single instance of SystemTimeIdGenerator.
	 *
	 * @return single instance of SystemTimeIdGenerator
	 */
	public static BigIntegerIdGenerator getInstance()
	{
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigInteger getNextId()
	{
		BigInteger nextId = atomicId.getAndIncrement();
		return nextId;
	}
}
