package tr.mhu.core.domain.dtos;

import lombok.Data;
import tr.mhu.core.domain.util.RequestDetail;

import java.time.LocalDateTime;


/**
 * @author muludag on 13.09.2020
 */
@Data
public class RegisterRequestDto implements RequestDetail {
	private String token;
	private String systemName;
}
