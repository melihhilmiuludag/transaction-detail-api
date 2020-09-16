package tr.mhu.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author muludag on 13.09.2020
 */
public enum EOperation {
	DIRECT("DIRECT"),
	REFUND("REFUND"),
	_3D("3D"),
	_3DAUTH("3DAUTH"),
	STORED("STORED"),
	;

	@Getter
	private final String operation;

	EOperation(String status) {
		this.operation = status;
	}

	@JsonCreator
	public static EOperation get(String operation) {
		for (EOperation e : EOperation.values()) {
			if (operation == e.getOperation())
				return e;
		}
		return null;
	}

	@JsonValue
	public String toValue() {
		return getOperation();
	}
}
