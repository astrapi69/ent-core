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
package io.github.astrapi69.entity.verifiable;

import java.util.UUID;

import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.data.identifiable.Identifiable;
import io.github.astrapi69.data.verifiable.VerifiableProcessable;
import io.github.astrapi69.entity.uniqueable.UUIDEntity;

/**
 * The class {@link VerifiableUUIDEntity} is a concrete class of {@link UUIDEntity} and holds an
 * {@link UUID} as primary key. It is for entity classes that have to be signed and verified
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public abstract class VerifiableUUIDEntity extends UUIDEntity
	implements
		Identifiable<UUID>,
		VerifiableProcessable
{

	/** The signature. */
	String signature;

	/**
	 * The processable flag will be set to false if this object has been manipulated from an
	 * inappropriate user. That means that the verification process failed and will be set from the
	 * verification process to false
	 */
	@Builder.Default
	boolean processable = true;

}
