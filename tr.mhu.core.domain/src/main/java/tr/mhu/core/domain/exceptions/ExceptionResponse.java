package tr.mhu.core.domain.exceptions;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class ExceptionResponse {
	String errorMessage;
	String errorCode;
	String callerURL;
	Timestamp timestamp;

}
