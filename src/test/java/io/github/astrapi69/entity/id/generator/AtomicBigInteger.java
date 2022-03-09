package io.github.astrapi69.entity.id.generator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicBigInteger
{

	private final AtomicReference<BigInteger> atomicReference;

	public AtomicBigInteger(final BigInteger bigInteger)
	{
		this.atomicReference = new AtomicReference<>(Objects.requireNonNull(bigInteger));
	}

	public BigInteger incrementAndGet()
	{
		return atomicReference.accumulateAndGet(BigInteger.ONE, (previous, x) -> previous.add(x));
	}

	public BigInteger getAndIncrement()
	{
		return atomicReference.getAndAccumulate(BigInteger.ONE, (previous, x) -> previous.add(x));
	}

	public BigInteger get()
	{
		return atomicReference.get();
	}
}
