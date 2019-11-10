/**
 * The MIT License
 *
 * Copyright (C) 2018 Asterios Raptis
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
package de.alpharogroup.db.entity.name.activatable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import de.alpharogroup.db.entity.name.IdentifiableNameableActivatable;
import de.alpharogroup.db.entity.name.NameEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link ActivatableNameEntity} is a base entity for a table with a single value
 *
 * @param <PK>
 *            the generic type of the id
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ActivatableNameEntity<PK extends Serializable> extends NameEntity<PK>
	implements
		IdentifiableNameableActivatable<PK>
{

	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;

	/** The attribute active indicates if this entity is active. */
	@Column(name = "active")
	boolean active;

	/**
	 * Instantiates a new {@link ActivatableNameEntity} with the given name
	 *
	 * @param name
	 *            the name
	 */
	public ActivatableNameEntity(String name)
	{
		super(name);
	}

}
