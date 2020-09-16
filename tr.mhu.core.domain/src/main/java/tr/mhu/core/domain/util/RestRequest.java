package tr.mhu.core.domain.util;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author muludag on 12.09.2020
 */
public class RestRequest<T extends RequestHeader, E extends RequestDetail> implements Serializable {
	@Valid
	@NotNull
	private transient T header;
	@Valid
	private transient E detail;

	public RestRequest() {
	}

	public T getHeader() {
		return this.header;
	}

	public void setHeader(T header) {
		this.header = header;
	}

	public E getDetail() {
		return this.detail;
	}

	public void setDetail(E detail) {
		this.detail = detail;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof RestRequest)) {
			return false;
		} else {
			RestRequest<?, ?> other = (RestRequest) o;
			return other.canEqual(this);
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof RestRequest;
	}

	public int hashCode() {
		int result = 1;
		return result;
	}

	public String toString() {
		return "RestRequest(header=" + this.getHeader() + ", detail=" + this.getDetail() + ")";
	}
}
