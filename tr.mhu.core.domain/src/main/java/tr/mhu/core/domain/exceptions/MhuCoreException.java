package tr.mhu.core.domain.exceptions;

import tr.mhu.core.domain.rest.RestResponseCode;

/**
 * @author muludag on 13.09.2020
 */
public class MhuCoreException extends RestException {
	public MhuCoreException(RestResponseCode restResponseCode) {
		super(restResponseCode);
	}
}
