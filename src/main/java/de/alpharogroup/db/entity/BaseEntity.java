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
package de.alpharogroup.db.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import de.alpharogroup.db.entity.enums.DatabasePrefix;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link BaseEntity} holds the primary key.
 *
 * @param <PK>
 *            the generic type of the technical primary key.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity<PK extends Serializable> implements Serializable, Identifiable<PK>
{

	/**
	 * The Constant for the generic sequence name. Note this must be given as name in the annotation
	 * SequenceGenerator if you want a sequence for the specific entity.
	 */
	public static final String SEQUENCE_GENERIC_GENERATOR_NAME = "hibernate_sequence";

	/**
	 * The constant for the foreign key prefix
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String FOREIGN_KEY_PREFIX = DatabasePrefix.FOREIGN_KEY_NAME.getPrefix();

	/**
	 * The constant for the index prefix
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String INDEX_PREFIX = DatabasePrefix.INDEX_NAME.getPrefix();

	/**
	 * The constant for the sequence generator prefix
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String SEQUENCE_GENERATOR_PREFIX = DatabasePrefix.SEQUENCE_GENERATOR_NAME
		.getPrefix();

	/**
	 * The constant for the sequence prefix
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String SEQUENCE_PREFIX = DatabasePrefix.SEQUENCE_NAME.getPrefix();

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The constant for the underscore
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String UNDERSCORE = DatabasePrefix.UNDERSCORE.getPrefix();

	/**
	 * The constant for the unique constraint prefix
	 *
	 * @deprecated use instead the same name constant from <code><DatabasePrefix/code> <br>
	 *             Note: will be removed in the next minor release version
	 **/
	@Deprecated
	public static final String UNIQUE_CONSTRAINT_PREFIX = DatabasePrefix.UNIQUE_CONSTRAINT_NAME
		.getPrefix();

	/** The technical primary key. */
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME)
	@Column(name = "id", nullable = false)
	PK id;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + ": id=" + id;
	}

}
