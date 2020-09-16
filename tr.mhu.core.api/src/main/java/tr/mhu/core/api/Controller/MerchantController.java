package tr.mhu.core.api.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.util.RequestHeaderDto;
import tr.mhu.core.domain.util.RestRequest;
import tr.mhu.core.service.MerchantService;

import javax.validation.Valid;

/**
 * @author muludag on 12.09.2020
 */
@RestController
@Slf4j
@RequestMapping("/api/v3")
public class MerchantController {

	private final MerchantService merchantService;

	@Autowired
	public MerchantController(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@PostMapping("/transaction/report")
	@ResponseBody
	public ResponseEntity<MerchantReportResponseDto> transactionReport(@Valid @RequestBody RestRequest<RequestHeaderDto, MerchantReportRequestDto> request) {
		return new ResponseEntity<>(merchantService.transactionReport(request), HttpStatus.OK);
	}

	@PostMapping("/transaction/list")
	@ResponseBody
	public ResponseEntity<MerchantListResponseDto> transactionList(@Valid @RequestBody RestRequest<RequestHeaderDto, MerchantListRequestDto> request) {
		return new ResponseEntity<>(merchantService.transactionList(request), HttpStatus.OK);
	}

	@PostMapping("/transaction")
	@ResponseBody
	public ResponseEntity<TransactionResponseDto> getTransaction(@Valid @RequestBody RestRequest<RequestHeaderDto, TransactionRequestDto> request) {
		return new ResponseEntity<>(merchantService.getTransaction(request), HttpStatus.OK);
	}

	@PostMapping("/client")
	@ResponseBody
	public ResponseEntity<ClientResponseDto> getClient(@Valid @RequestBody RestRequest<RequestHeaderDto, TransactionRequestDto> request) {
		return new ResponseEntity<>(merchantService.getClient(request), HttpStatus.OK);
	}
}
