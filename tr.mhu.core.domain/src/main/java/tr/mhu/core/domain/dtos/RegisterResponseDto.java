package tr.mhu.core.domain.dtos;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import tr.mhu.core.domain.entites.Register;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author muludag on 13.09.2020
 */
@Slf4j
@Value
public class RegisterResponseDto implements Serializable {
	private String token;
	private String systemName;


	public static RegisterResponseDto convertFrom(Register e) {
		RegisterResponseDto dto = new RegisterResponseDto(e.getToken(), e.getSystemName());
		if (!(Duration.between(LocalDateTime.now(), e.getExpireDate()).toMinutes() > 1)) {
			log.error("expire date");
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}
		return dto;
	}
}

