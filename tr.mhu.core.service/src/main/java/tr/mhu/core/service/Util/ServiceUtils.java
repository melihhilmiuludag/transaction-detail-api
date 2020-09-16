package tr.mhu.core.service.Util;

import tr.mhu.core.domain.exceptions.MhuCoreException;
import tr.mhu.core.domain.rest.RestResponseCode;

import java.util.HashMap;

/**
 * @author muludag on 16.09.2020
 */
public class ServiceUtils {

	public final static String splitPrefix = "/";

	public static HashMap<String, String> registerInfoResolve(String value) {
		HashMap<String, String> map = new HashMap<>();
		if (value == null) return null;
		String[] arrOfStr = value.split(splitPrefix, 2);
		map.put("registerId", arrOfStr[0]);
		map.put("jwtToken", arrOfStr[1]);
		return map;
	}

	public static String registerInfoModel(String uuid, String jwtToken) {
		HashMap<String, String> map = new HashMap<>();
		if (uuid == null && jwtToken == null) return null;
		return String.join(splitPrefix, uuid, jwtToken);
	}

	public static String tapTopEditStringJwtToken(String strJwtToken) {
		if (strJwtToken == null) throw new MhuCoreException(RestResponseCode.NOT_FOUND_REGISTER);
		return strJwtToken.split("\"")[1] == null ? strJwtToken : strJwtToken.split("\"")[1];
	}
}
