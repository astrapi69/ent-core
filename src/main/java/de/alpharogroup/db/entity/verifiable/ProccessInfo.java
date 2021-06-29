package de.alpharogroup.db.entity.verifiable;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

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
	 **/
	public boolean isProcessable() {
		return VerificationState.VERIFIED.equals(state);
	}

}
