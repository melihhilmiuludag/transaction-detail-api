package tr.mhu.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author muludag on 13.09.2020
 */
public enum EFilterField {
	TRANSACTION_UUID("Transaction UUID"),
	CUSTOMER_EMAIL("Customer Email"),
	REFERENCE_NO("Reference No"),
	CUSTOM_DATA("Custom Data"),
	CARD_PAN("Card PAN"),
	;

	@Getter
	private final String filterField;

	EFilterField(String filterField) {
		this.filterField = filterField;
	}

	@JsonCreator
	public static EFilterField get(String filterField) {
		for (EFilterField e : EFilterField.values()) {
			if (filterField == e.getFilterField())
				return e;
		}
		return null;
	}

	@JsonValue
	public String toValue() {
		return getFilterField();
	}
}
