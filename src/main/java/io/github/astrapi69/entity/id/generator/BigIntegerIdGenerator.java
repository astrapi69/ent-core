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

import lombok.NonNull;
import io.github.astrapi69.data.identifiable.IdGenerator;

/**
 * The class {@link BigIntegerIdGenerator} is an implementation of {@link IdGenerator} interface
 * with id type of {@link BigInteger} object
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
	 * @param initialValue
	 *            the initial value for the generator
	 */
	private BigIntegerIdGenerator(final @NonNull BigInteger initialValue)
	{
		atomicId = new AtomicBigInteger(initialValue);
	}

	/**
	 * Factory method for create a new custom {@link BigIntegerIdGenerator} with an initial value
	 *
	 * @param initialValue
	 *            the initial value for the generator
	 */
	public static BigIntegerIdGenerator of(final @NonNull BigInteger initialValue)
	{
		return new BigIntegerIdGenerator(initialValue);
	}

	/**
	 * Gets the single instance of {@link BigIntegerIdGenerator}.
	 *
	 * @return single instance of {@link BigIntegerIdGenerator}
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
		return atomicId.getAndIncrement();
	}
}
