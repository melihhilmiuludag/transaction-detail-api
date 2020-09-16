package tr.mhu.core.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import tr.mhu.core.data.RegisterRepository;
import tr.mhu.core.domain.dtos.RegisterRequestDto;
import tr.mhu.core.domain.dtos.RegisterResponseDto;
import tr.mhu.core.domain.entites.Register;
import tr.mhu.core.domain.exceptions.MhuCoreException;
import tr.mhu.core.domain.rest.RestResponseCode;
import tr.mhu.core.service.Cache.IMhuCoreCache;
import tr.mhu.core.service.RegisterService;

import java.time.LocalDateTime;

/**
 * @author muludag on 13.09.2020
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

	public static final String JWT_TOKEN = "jwtToken";
	private final RegisterRepository registerRepository;
	private final IMhuCoreCache mhuCoreCache;
	private final Environment environment;
	@Value("${mhu-core.register.expire.min:10}")
	private long expireMin;

	@Autowired
	public RegisterServiceImpl(RegisterRepository registerRepository, IMhuCoreCache mhuCoreCache, Environment environment) {
		this.registerRepository = registerRepository;
		this.mhuCoreCache = mhuCoreCache;
		this.environment = environment;
	}

	Register toRegister(String jwtToken, final String systemName) {
		Register e = new Register();
		e.setCreatedDate(LocalDateTime.now());
		e.setExpireDate(LocalDateTime.now().plusMinutes(expireMin));
		e.setSystemName(systemName);
		e.setToken(jwtToken);
		return e;
	}

	@Override
	public RegisterResponseDto getRegister(String id) {
		return RegisterResponseDto.convertFrom(this.registerRepository.findById(id).orElseThrow(() -> new MhuCoreException(RestResponseCode.NOT_FOUND_REGISTER)));
	}

	@Override
	public String saveRegister(RegisterRequestDto registerRequestDto) {
		Register e = new Register();
		e.setCreatedDate(LocalDateTime.now());
		e.setExpireDate(LocalDateTime.now().plusMinutes(expireMin));
		e.setSystemName(registerRequestDto.getSystemName());
		e.setToken(registerRequestDto.getToken());
		registerRepository.save(e);
		return e.getId();
	}

	@Override
	public String saveRegister(String jwtToken, final String systemName) {
		if (Boolean.parseBoolean(environment.getProperty("using.cahce"))) {
			//caching
			mhuCoreCache.add(JWT_TOKEN, jwtToken, expireMin * 60 * 1000);
			return "RegisterId Caching in java app! Also non required jwtToken parameter in request body :)";
		} else {
			//not use caching. using db.
			return registerRepository.save(toRegister(jwtToken, systemName)).getId();
		}
	}

	@Override
	public String getJwtToken(String uuid) {
		if (Boolean.parseBoolean(environment.getProperty("using.cahce"))) {
			if (mhuCoreCache.get(JWT_TOKEN) == null)
				throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
			return String.valueOf(mhuCoreCache.get(JWT_TOKEN));
		} else {
			if (uuid == null || uuid.equals("")) throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
			return this.getRegister(uuid).getToken();
		}
	}
}
