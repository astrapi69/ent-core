package io.github.astrapi69.entity.verifiable;

/**
 * The enum {@link VerificationState} holds the state of a verifiable object
 */
public enum VerificationState
{

	/**
	 * The state <code>VerificationState#BROKEN</code> signals that a verifiable object
	 * has been manipulated and therefore not processable anymore. An investigation have to be
	 * started to find the cause of the manipulation
	 */
	BROKEN,

	/**
	 * The state <code>VerificationState#EVALUATE</code> signals an investigation has
	 * started to find the cause of the manipulation
	 */
	EVALUATE,

	/**
	 * The state <code>VerificationState#RESET</code> signals that the investigation has
	 * finished and the signature of the verifiable object can be new generated and set
	 */
	RESET,

	/**
	 * The state <code>VerificationState#VERIFIED</code> signals that the verifiable object
	 * is verified and is processable
	 */
	VERIFIED
}
