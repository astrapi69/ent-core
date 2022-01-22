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
package io.github.astrapi69.entity.validatable.versionable;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.data.validatable.versionable.IdentifiableValidatableVersionable;
import io.github.astrapi69.entity.validatable.ValidatableEntity;

/**
 * The class {@link VersionableValidatableEntity} is a base entity and has a validFrom property and
 * a validTill property for restricting an entity in a time range in which it is valid.
 *
 * @param <PK>
 *            the generic type of the id
 * @param <T>
 *            the generic type of time measurement
 */
@MappedSuperclass
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
public abstract class VersionableValidatableEntity<PK extends Serializable, T>
	extends
		ValidatableEntity<PK, T>
	implements
		IdentifiableValidatableVersionable<PK, T>
{

	/**
	 * The version property for the optimistic lock value.
	 **/
	@Version
	private Integer version;
}
