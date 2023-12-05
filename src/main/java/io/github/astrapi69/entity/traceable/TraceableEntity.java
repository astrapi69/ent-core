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
package io.github.astrapi69.entity.traceable;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.data.traceable.IdentifiableTraceable;
import io.github.astrapi69.entity.creatable.Creation;
import io.github.astrapi69.entity.deletable.Deletion;
import io.github.astrapi69.entity.identifiable.SequenceBaseEntity;
import io.github.astrapi69.entity.modifiable.LastModification;

/**
 * The entity class {@link TraceableEntity} is keeping the information for the creation, last
 * modification and for the deletion of an entity. <br>
 *
 * @param <PK>
 *            the generic type of the id
 * @param <T>
 *            the generic type of time measurement
 * @param <U>
 *            the generic type of the user or account
 * @see Creation
 * @see Deletion
 * @see LastModification
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class TraceableEntity<PK extends Serializable, T, U> extends SequenceBaseEntity<PK>
	implements
		IdentifiableTraceable<PK, T, U>
{

	/** The date and time when the entity that owns this entity was created. */
	private T created;

	/** The user or account that created the entity that owns this entity. */
	private U createdBy;

	/** The date and time when the entity that owns this entity was deleted. */
	private T deleted;

	/** The user or account that deleted the entity that owns this entity. */
	private U deletedBy;

	/** The date and time when the entity that owns this entity was modified. */
	private T lastModified;

	/** The user or account that modified the entity that owns this entity. */
	private U lastModifiedBy;

}
