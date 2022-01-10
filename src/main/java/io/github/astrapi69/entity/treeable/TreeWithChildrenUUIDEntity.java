package io.github.astrapi69.entity.treeable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.entity.uniqueable.UUIDEntity;

import java.util.Collection;

/**
 * The Entity class {@link TreeWithChildrenUUIDEntity} can keep information for a tree structure.
 * The root {@link TreeWithChildrenUUIDEntity} has no parent, all other
 * {@link TreeWithChildrenUUIDEntity} objects have a parent.
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class TreeWithChildrenUUIDEntity<T, TR extends Treeable<T, TR>> extends UUIDEntity
	implements
		Treeable<T, TR>
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
	@OneToMany(mappedBy="parent")
	Collection<TR> children;

	/** The value of this tree entity */
	@Column(name = "value", columnDefinition = "TEXT")
	T value;

}
