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
package de.alpharogroup.db.entity.treeable;

import de.alpharogroup.db.entity.base.SequenceBaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Entity class {@link TreeableEntity} can keep information with a tree structure. The root
 * {@link TreeableEntity} has no parent all child {@link TreeableEntity}s have a parent.
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public abstract class TreeableEntity<PK extends Serializable, T, TR extends Treeable<PK, T, ?>>
	extends
		SequenceBaseEntity<PK>
	implements
		Cloneable,
		Treeable<PK, T, TR>
{

	/** The depth of this node. For the root depth would be 0. */
	@Column(name = "depth")
	int depth;

	/** A flag that indicates if this tree entity is a node */
	@Column(name = "node")
	boolean node;

	/** The parent tree entity that references to the parent. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_treeable_parent_id"))
	TR parent;

	/** The value of this tree entity */
	@Column(name = "value", columnDefinition = "TEXT")
	T value;

}
