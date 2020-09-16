package tr.mhu.core.service;

import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.util.RequestHeaderDto;
import tr.mhu.core.domain.util.RestRequest;

/**
 * @author muludag on 12.09.2020
 */
public interface MerchantService {
	MerchantReportResponseDto transactionReport(RestRequest<RequestHeaderDto, MerchantReportRequestDto> request);

	MerchantListResponseDto transactionList(RestRequest<RequestHeaderDto, MerchantListRequestDto> request);

	ClientResponseDto getClient(RestRequest<RequestHeaderDto, TransactionRequestDto> request);

	TransactionResponseDto getTransaction(RestRequest<RequestHeaderDto, TransactionRequestDto> request);

}
