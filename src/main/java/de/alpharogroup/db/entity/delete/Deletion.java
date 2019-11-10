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
package de.alpharogroup.db.entity.delete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import de.alpharogroup.db.entity.base.SequenceBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The entity class {@link Deletion} acts like an deletion flag that keeps the information for the
 * deletion of another entity that have this entity as an instance variable. This information are
 * the date when it was deleted and from whom it was deleted. So this entity can be attached to
 * another entity for keeping information if it is deleted and when it was deleted. <br>
 * <br>
 * In specific situation entities have to be kept for instance of historical purposes. So the intent
 * of this entity is that a parent entity will not really be deleted. The initial value of the
 * parent entity that keeps this entity as an instance variable as a null object that signals that
 * it is not deleted, and when it get a value with the deletion data it signals that it is now
 * deleted and is not visible to selections. <br>
 * <br>
 * Note: So this entity will only be created if the parent entity references to this entity and is
 * intended to be deleted. This can be done for instance in a deletion strategy.
 *
 * Note: There is no need of a delete flag in this entity because this entity is the flag. So if the
 * parent entity is not any more 'deleted' the reference of this entity will be set to null back.
 *
 * @param <PK>
 *            the generic type of the id
 * @param <T>
 *            the generic type of time measurement
 * @param <U>
 *            the generic type of the user or account
 */
@Entity
@Table(name = "deletion")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Deletion<PK extends Serializable, T, U> extends SequenceBaseEntity<PK>
	implements
		IdentifiableDeletable<PK, T, U>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The date and time when the entity that owns this entity was deleted. */
	private T deleted;

	/** The user or account that deleted the entity that owns this entity. */
	private U deletedBy;

}
