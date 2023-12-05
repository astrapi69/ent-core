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
package io.github.astrapi69.entity.treeable;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.data.treeable.TreeWithChildren;
import io.github.astrapi69.entity.uniqueable.UUIDEntity;

/**
 * The Entity class {@link TreeWithChildrenUUIDEntity} can keep information for a tree structure.
 * The root {@link TreeWithChildrenUUIDEntity} has no parent, all other
 * {@link TreeWithChildrenUUIDEntity} objects have a parent.
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class TreeWithChildrenUUIDEntity<T, TR extends TreeWithChildren<T, TR>> extends UUIDEntity
	implements
		TreeWithChildren<T, TR>
{

	/** The depth of this node. For the root depth would be 0 */
	@Column(name = "depth")
	int depth;

	/** A flag that indicates if this tree entity is a node or a leaf */
	@Column(name = "node")
	boolean node;

	/** The parent tree entity that references to the parent */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_treeable_parent_id"))
	TR parent;

	/** The children of this entity */
	@OneToMany(mappedBy = "parent")
	@Builder.Default
	Collection<TR> children = new ArrayList<>();

	/** The value of this tree entity */
	@Column(name = "value", columnDefinition = "TEXT")
	T value;

	/**
	 * Adds the given child to the children collection
	 * 
	 * @param child
	 *            the child to add
	 */
	public void addChild(TR child)
	{
		if (!children.contains(child))
		{
			children.add(child);
		}
	}

	/**
	 * Removes the given child from the children collection
	 * 
	 * @param child
	 *            the child to remove
	 */
	public void removeChild(TR child)
	{
		children.remove(child);
	}
}
