package io.github.astrapi69.entity.id.generator;

public enum SequenceValue
{

	INITIAL_VALUE(SequenceValue.DEFAULT_SEQUENCE_INITIAL_VALUE), SEQUENCE_PREFIX(
		SequenceValue.DEFAULT_SEQUENCE_PREFIX), SEQUENCE_ID_KEY(
			SequenceValue.DEFAULT_SEQUENCE_ID_KEY);

	public static final String DEFAULT_SEQUENCE_INITIAL_VALUE = "1";
	public static final String DEFAULT_SEQUENCE_PREFIX = "seq_";
	public static final String DEFAULT_SEQUENCE_ID_KEY = DEFAULT_SEQUENCE_PREFIX + "id";

	String value;

	SequenceValue(String value)
	{
		this.value = value;
	}
}
