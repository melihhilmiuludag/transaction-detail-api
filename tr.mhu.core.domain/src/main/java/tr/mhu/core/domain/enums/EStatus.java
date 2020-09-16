package tr.mhu.core.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author muludag on 13.09.2020
 */
public enum EStatus {
	APPROVED("APPROVED"),
	WAITING("WAITING"),
	DECLINED("DECLINED"),
	ERROR("ERROR"),
	;

	@Getter
	private final String status;

	EStatus(String status) {
		this.status = status;
	}

	@JsonCreator
	public static EStatus get(String status) {
		for (EStatus e : EStatus.values()) {
			if (status == e.getStatus())
				return e;
		}
		return null;
	}

	@JsonValue
	public String toValue() {
		return getStatus();
	}
}
