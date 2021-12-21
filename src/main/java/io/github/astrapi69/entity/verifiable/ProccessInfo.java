package io.github.astrapi69.entity.verifiable;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * The {@link ProccessInfo} class stores information about the process of the verification state
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class ProccessInfo
{

	/**
	 * An optional reason why the verifiable object is not processable
	 * */
	String notProcessableReason;

	/**
	 * An optional reason why the verifiable object is not processable
	 * */
	@Builder.Default
	VerificationState state = VerificationState.VERIFIED;

	/**
	 * Checks if the verifiable object is processable
	 * @return true if the verifiable object is processable otherwise false
	 **/
	public boolean isProcessable() {
		return VerificationState.VERIFIED.equals(state);
	}

}
