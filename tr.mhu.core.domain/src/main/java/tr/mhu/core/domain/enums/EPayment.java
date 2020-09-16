package tr.mhu.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author muludag on 13.09.2020
 */
public enum EPayment {
	CREDITCARD("CREDITCARD"),
	CUP("CUP"),
	IDEAL("IDEAL"),
	GIROPAY("GIROPAY"),
	MISTERCASH("MISTERCASH"),
	STORED("STORED"),
	PAYTOCARD("PAYTOCARD"),
	CEPBANK("CEPBANK"),
	CITADEL("CITADEL"),
	;

	@Getter
	private final String payment;

	EPayment(String payment) {
		this.payment = payment;
	}

	@JsonCreator
	public static EPayment get(String payment) {
		for (EPayment e : EPayment.values()) {
			if (payment == e.getPayment())
				return e;
		}
		return null;
	}

	@JsonValue
	public String toValue() {
		return getPayment();
	}
}
