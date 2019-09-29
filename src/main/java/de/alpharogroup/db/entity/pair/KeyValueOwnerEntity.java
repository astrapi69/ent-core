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
package de.alpharogroup.db.entity.pair;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import de.alpharogroup.db.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The abstract entity class {@link KeyValueOwnerEntity} holds a generic key value pair with his
 * owner which can be also the parent if it is from the same type.
 *
 * @param <PK>
 *            the generic type of the technical primary key
 * @param <O>
 *            the generic type of the owner
 * @param <K>
 *            the generic type of the key
 * @param <V>
 *            the generic type of the value
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class KeyValueOwnerEntity<PK extends Serializable, O, K, V> extends BaseEntity<PK>
	implements
		IdentifiableKeyValueOwner<PK, O, K, V>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant for the column name 'key'. */
	public static final String COLUMN_NAME_KEY = "key";

	/** The Constant for the column name 'owner'. */
	public static final String COLUMN_NAME_OWNER = "owner";

	/** The Constant for the column name 'value'. */
	public static final String COLUMN_NAME_VALUE = "value";

	/** The key of this key-value pair. */
	@Column(name = "key", nullable = false)
	K key;

	/** The owner of this key-value pair. */
	@Column(name = "owner", nullable = false)
	O owner;

	/** The value of this key-value pair. */
	@Column(name = "value")
	V value;

}
