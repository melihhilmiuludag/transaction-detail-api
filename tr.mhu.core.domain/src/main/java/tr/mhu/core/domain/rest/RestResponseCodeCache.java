package tr.mhu.core.domain.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author muludag on 13.09.2020
 */
public class RestResponseCodeCache {
	private static final List<RestResponseCode> VALUES = new ArrayList();

	private RestResponseCodeCache() {
	}

	public static void add(RestResponseCode restResponseCode) {
		VALUES.add(restResponseCode);
	}

	public static List<RestResponseCode> getValues() {
		return VALUES;
	}

	public static RestResponseCode findByMessage(String message) {
		Iterator var1 = VALUES.iterator();

		RestResponseCode restResponseCode;
		do {
			if (!var1.hasNext()) {
				return null;
			}

			restResponseCode = (RestResponseCode)var1.next();
		} while(!restResponseCode.getMessage().equals(message));

		return restResponseCode;
	}

	public static List<RestResponseCode> findByCodeStartsWith(String code) {
		List<RestResponseCode> list = new ArrayList();
		Iterator var2 = VALUES.iterator();

		while(var2.hasNext()) {
			RestResponseCode restResponseCode = (RestResponseCode)var2.next();
			if (restResponseCode.getCode().startsWith(code)) {
				list.add(restResponseCode);
			}
		}

		return list;
	}
}
