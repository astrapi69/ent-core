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
package de.alpharogroup.db.entity.name.versionable;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import de.alpharogroup.db.entity.name.IdentifiableNameableVersionable;
import de.alpharogroup.db.entity.name.UniqueNameEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link VersionableUniqueNameEntity} is a base entity for a table with a single unique
 * value
 *
 * @param <PK>
 *            the generic type of the id
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class VersionableUniqueNameEntity<PK extends Serializable>
	extends
		UniqueNameEntity<PK>
	implements
		IdentifiableNameableVersionable<PK>
{

	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The version property for the optimistic lock value
	 **/
	@Version
	Integer version;

	/**
	 * Instantiates a new {@link VersionableUniqueNameEntity} with the given name
	 *
	 * @param name the name
	 */
	public VersionableUniqueNameEntity(String name)
	{
		super(name);
	}

}
