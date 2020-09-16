package tr.mhu.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author muludag on 13.09.2020
 */
public enum EErrorCode {
	DONT_HONOR("Do not honor"),
	INVALID_TRANSACTION("Invalid Transaction"),
	INVALID_CARD("Invalid Card"),
	NOT_SUFFICIENT_FUNDS("Not sufficient funds"),
	IN_CORRECT_PIN("Incorrect PIN"),
	INVALID_COUNTRY_ASSOCIATION("Invalid country association"),
	CURRENCY_NOT_ALLOWED("Currency not allowed"),
	_3D_SECURE_TRANSPORT_ERROR("3-D Secure Transport Error"),
	TRANSACTION_NOT_PERMITTED_CARD_HOLDER("Transaction not permitted to cardholder"),
	;

	@Getter
	private final String errorCode;

	EErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@JsonCreator
	public static EErrorCode get(String errorCode) {
		for (EErrorCode e : EErrorCode.values()) {
			if (errorCode == e.getErrorCode())
				return e;
		}
		return null;
	}

	@JsonValue
	public String toValue() {
		return getErrorCode();
	}
}
