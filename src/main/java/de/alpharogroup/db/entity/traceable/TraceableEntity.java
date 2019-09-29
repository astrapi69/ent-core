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
package de.alpharogroup.db.entity.traceable;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import de.alpharogroup.db.entity.BaseEntity;
import de.alpharogroup.db.entity.create.Creation;
import de.alpharogroup.db.entity.delete.Deletion;
import de.alpharogroup.db.entity.modify.LastModification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class TraceableEntity<PK extends Serializable, T, U> extends BaseEntity<PK>
	implements
		IdentifiableTraceable<PK, T, U>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant for the column name 'created'. */
	public static final String COLUMN_NAME_CREATED = "created";

	/** The Constant for the column name 'active'. */
	public static final String COLUMN_NAME_CREATED_BY = "createdBy";

	/** The Constant for the column name 'deleted'. */
	public static final String COLUMN_NAME_DELETED = "deleted";

	/** The Constant for the column name 'deletedBy'. */
	public static final String COLUMN_NAME_DELETED_BY = "deletedBy";

	/** The Constant for the column name 'lastModified'. */
	public static final String COLUMN_NAME_LAST_MODIFIED = "lastModified";

	/** The Constant for the column name 'lastModifiedBy'. */
	public static final String COLUMN_NAME_LAST_MODIFIED_BY = "lastModifiedBy";

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
