package tr.mhu.core.service;

import tr.mhu.core.domain.dtos.RegisterRequestDto;
import tr.mhu.core.domain.dtos.RegisterResponseDto;

/**
 * @author muludag on 13.09.2020
 */
public interface RegisterService {
	RegisterResponseDto getRegister(String id);

	String saveRegister(RegisterRequestDto registerRequestDto);

	String saveRegister(String jwtToken, final String systemName);

	String getJwtToken(String uuid);
}
