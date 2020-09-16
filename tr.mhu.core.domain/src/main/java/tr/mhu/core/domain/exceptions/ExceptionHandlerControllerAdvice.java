package tr.mhu.core.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import tr.mhu.core.domain.rest.RestResponseCode;
import tr.mhu.core.domain.util.LocalizationResolver;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author muludag on 13.09.2020
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	private final LocalizationResolver localizationResolver;

	public ExceptionHandlerControllerAdvice(LocalizationResolver localizationResolver) {
		this.localizationResolver = localizationResolver;
	}


	@ExceptionHandler(MhuCoreException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	public @ResponseBody
	ExceptionResponse handleResourceNotFound(final MhuCoreException exception,
											 final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(localizationResolver.resolve(exception.getMessage()));
		error.setTimestamp(new Timestamp(System.currentTimeMillis()));
		error.setErrorCode(exception.getRestResponseCode().getCode());
		error.setCallerURL(request.getRequestURI());

		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ExceptionResponse handleValidException(final MethodArgumentNotValidException exception,
									  final HttpServletRequest request) {


		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(localizationResolver.resolve(RestResponseCode.INVALID_REQUEST_BODY.getMessage()));
		error.setTimestamp(new Timestamp(System.currentTimeMillis()));
		error.setErrorCode(RestResponseCode.INVALID_REQUEST_BODY.getCode());
		error.setCallerURL(request.getRequestURI());

		return error;
	}

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ExceptionResponse handleHttpClientException(final HttpClientErrorException exception,
									  final HttpServletRequest request) {


		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setTimestamp(new Timestamp(System.currentTimeMillis()));
		error.setErrorCode(exception.getStatusCode().toString());
		error.setCallerURL(request.getRequestURI());

		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ExceptionResponse handleException(final Exception exception,
									  final HttpServletRequest request) {


		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(localizationResolver.resolve(exception.getMessage()));
		error.setTimestamp(new Timestamp(System.currentTimeMillis()));
		error.setErrorCode(RestResponseCode.ERROR.getCode());
		error.setCallerURL(request.getRequestURI());

		return error;
	}
}
