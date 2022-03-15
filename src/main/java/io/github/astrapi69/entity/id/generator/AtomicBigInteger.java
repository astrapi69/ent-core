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

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import lombok.NonNull;

/**
 * The class {@link AtomicBigInteger} holds a {@link BigInteger} value that may be updated
 * atomically
 * @deprecated use instead the same name class from the module id-generate
 */
public final class AtomicBigInteger
{

	private final AtomicReference<BigInteger> atomicReference;

	/**
	 * Creates a new AtomicInteger with the given initial value.
	 *
	 * @param initialValue
	 *            the initial value
	 */
	public AtomicBigInteger(final @NonNull BigInteger initialValue)
	{
		this.atomicReference = new AtomicReference<>(initialValue);
	}

	/**
	 * Atomically increments by one the current value
	 *
	 * @return the incremented value
	 */
	public BigInteger incrementAndGet()
	{
		return atomicReference.accumulateAndGet(BigInteger.ONE, BigInteger::add);
	}

	/**
	 * Atomically increments by one the current value.
	 *
	 * @return the previous value
	 */
	public BigInteger getAndIncrement()
	{
		return atomicReference.getAndAccumulate(BigInteger.ONE, BigInteger::add);
	}

	/**
	 * Gets the current value.
	 *
	 * @return the current value
	 */
	public BigInteger get()
	{
		return atomicReference.get();
	}
}
