package tr.mhu.core.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.mhu.core.domain.dtos.RegisterSaveResponseDto;
import tr.mhu.core.domain.util.RequestDetail;
import tr.mhu.core.domain.util.RequestHeaderDto;
import tr.mhu.core.domain.util.RestRequest;
import tr.mhu.core.service.RegisterService;

import javax.validation.Valid;

/**
 * @author muludag on 13.09.2020
 */
@RestController
@Slf4j
@RequestMapping("/system/v1")
public class RegisterController {

	private final RegisterService registerService;

	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@PostMapping("/register/save")
	@ResponseBody
	public ResponseEntity<RegisterSaveResponseDto> saveRegister(@Valid @RequestBody RestRequest<RequestHeaderDto, RequestDetail> request) {
		RegisterSaveResponseDto responseDto = new RegisterSaveResponseDto();
		String registerKey = registerService.saveRegister(request.getHeader().getJwtToken(), request.getHeader().getSystem());
		responseDto.setRegisterId(registerKey);
		return new ResponseEntity<>((responseDto), HttpStatus.OK);
	}
}
