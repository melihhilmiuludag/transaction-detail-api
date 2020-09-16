package tr.mhu.core.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.util.RequestHeaderDto;
import tr.mhu.core.domain.util.RestRequest;
import tr.mhu.core.service.Client.RpdPaymentClient;
import tr.mhu.core.service.MerchantService;
import tr.mhu.core.service.RegisterService;

/**
 * @author muludag on 12.09.2020
 */
@Slf4j
@Service
public class MerchantServiceImpl implements MerchantService {

	private final RpdPaymentClient rpdPaymentClient;
	private final RegisterService registerService;

	@Autowired
	public MerchantServiceImpl(RpdPaymentClient rpdPaymentClient, RegisterService registerService) {
		this.rpdPaymentClient = rpdPaymentClient;
		this.registerService = registerService;
		;
	}

	@Override
	public MerchantReportResponseDto transactionReport(RestRequest<RequestHeaderDto, MerchantReportRequestDto> request) {
		return this.rpdPaymentClient.transactionReport(this.registerService.getJwtToken(request.getHeader().getJwtToken()), request.getDetail());
	}

	@Override
	public MerchantListResponseDto transactionList(RestRequest<RequestHeaderDto, MerchantListRequestDto> request) {
		return this.rpdPaymentClient.transactionList(this.registerService.getJwtToken(request.getHeader().getJwtToken()), request.getDetail());
	}

	@Override
	public ClientResponseDto getClient(RestRequest<RequestHeaderDto, TransactionRequestDto> request) {
		return this.rpdPaymentClient.getClient(this.registerService.getJwtToken(request.getHeader().getJwtToken()), request.getDetail());
	}

	@Override
	public TransactionResponseDto getTransaction(RestRequest<RequestHeaderDto, TransactionRequestDto> request) {
		return this.rpdPaymentClient.getTransaction(this.registerService.getJwtToken(request.getHeader().getJwtToken()), request.getDetail());
	}
}
