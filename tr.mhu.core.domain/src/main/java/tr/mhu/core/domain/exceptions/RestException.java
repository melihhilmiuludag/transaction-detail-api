package tr.mhu.core.domain.exceptions;

import tr.mhu.core.domain.rest.RestResponseCode;

/**
 * @author muludag on 13.09.2020
 */
public class RestException extends RuntimeException {
	private final RestResponseCode restResponseCode;

	public RestException(RestResponseCode restResponseCode) {
		super(restResponseCode.getMessage());
		this.restResponseCode = restResponseCode;
	}

	public RestException(RestResponseCode restResponseCode, String message) {
		super(message);
		this.restResponseCode = restResponseCode;
	}

	public RestResponseCode getRestResponseCode() {
		return this.restResponseCode;
	}
}
