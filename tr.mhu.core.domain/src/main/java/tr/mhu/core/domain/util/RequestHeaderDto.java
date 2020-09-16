package tr.mhu.core.domain.util;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author muludag on 12.09.2020
 */
public class RequestHeaderDto implements RequestHeader, Serializable {

	private final static String SYSTEM_NAME="mhu-core";

	@NotNull(message = "system.info.invalid")
	@Length(
			min = 1,
			max = 50,
			message = "system.info.invalid"
	)
	private String system;

	private String jwtToken;

	public RequestHeaderDto() {
	}

	@ConstructorProperties({"system", "jwtToken"})
	public RequestHeaderDto(String system, String jwtToken) {
		this.system = system;
		this.jwtToken = jwtToken;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getJwtToken() {
		return this.jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RequestHeaderDto that = (RequestHeaderDto) o;
		return system.equals(that.system) &&
				jwtToken.equals(that.jwtToken);
	}

	protected boolean canEqual(Object other) {
		return other instanceof RequestHeaderDto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(system, jwtToken);
	}

	public String toString() {
		return "RequestHeaderDto(system=" + this.getSystem() + ", jwtToken=" + this.getJwtToken() + ")";
	}
}
