package de.alpharogroup.db.entity.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * The enum {@link DatabasePrefix} holds some useful prefixes forn sequences and indexes
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum DatabasePrefix
{
	/** The prefix for the sequence name */
	SEQUENCE_NAME("seq_nm_"),
	/** The prefix for the sequence generator name */
	SEQUENCE_GENERATOR_NAME("seq_gen_nm_"),
	/** The prefix for the index */
	INDEX("idx_");
	String prefix;
}
