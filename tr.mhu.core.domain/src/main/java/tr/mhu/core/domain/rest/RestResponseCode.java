package tr.mhu.core.domain.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author muludag on 13.09.2020
 */
public class RestResponseCode implements Serializable {

	/******** messages ********/
	public static final RestResponseCode SUCCESS = new RestResponseCode("0", "general.result.info.success");
	public static final RestResponseCode ERROR = new RestResponseCode("-1", "general.system.error");
	public static final RestResponseCode INVALID_SYSTEM_INFO = new RestResponseCode("-2", "system.info.invalid");
	public static final RestResponseCode INVALID_REQUEST_BODY = new RestResponseCode("-3", "invalid.request.body");
	public static final RestResponseCode NOT_FOUND_REGISTER = new RestResponseCode("-4", "not.found.register.error");


	/******** messages ********/


	private final String code;
	private final String message;

	public RestResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}


	@JsonCreator
	public static RestResponseCode get(String code) {
		if (code != null && !code.isEmpty()) {
			Iterator var1 = RestResponseCodeCache.getValues().iterator();

			RestResponseCode e;
			do {
				if (!var1.hasNext()) {
					return null;
				}

				e = (RestResponseCode) var1.next();
			} while (!code.equals(e.code));

			return e;
		} else {
			return null;
		}
	}

	public static RestResponseCode findByMessage(String message) {
		Iterator var1 = RestResponseCodeCache.getValues().iterator();

		RestResponseCode e;
		do {
			if (!var1.hasNext()) {
				return null;
			}

			e = (RestResponseCode) var1.next();
		} while (!message.equals(e.message));

		return e;
	}

	public static RestResponseCode findByMessageEndsWith(String message) {
		Iterator var1 = RestResponseCodeCache.getValues().iterator();

		RestResponseCode e;
		do {
			if (!var1.hasNext()) {
				return null;
			}

			e = (RestResponseCode) var1.next();
		} while (!e.message.endsWith(message));

		return e;
	}

	public static List<RestResponseCode> findByMessageStartsWith(String message) {
		List<RestResponseCode> restResponseList = new ArrayList();
		Iterator var2 = RestResponseCodeCache.getValues().iterator();

		while (var2.hasNext()) {
			RestResponseCode e = (RestResponseCode) var2.next();
			if (e.message.startsWith(message)) {
				restResponseList.add(e);
			}
		}

		return restResponseList;
	}

	@JsonValue
	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}


	static {
		RestResponseCodeCache.add(SUCCESS);
		RestResponseCodeCache.add(ERROR);
		RestResponseCodeCache.add(INVALID_REQUEST_BODY);
		RestResponseCodeCache.add(INVALID_SYSTEM_INFO);
		RestResponseCodeCache.add(NOT_FOUND_REGISTER);
	}


}
