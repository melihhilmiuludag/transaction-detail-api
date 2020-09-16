package tr.mhu.core.service.Client;

import tr.mhu.core.domain.dtos.*;

/**
 * @author muludag on 12.09.2020
 */
public interface RpdPaymentClient {
	MerchantReportResponseDto transactionReport(String jwtToken, MerchantReportRequestDto requestDto);

	MerchantListResponseDto transactionList(String jwtToken, MerchantListRequestDto requestDto);

	ClientResponseDto getClient(String tokenMap, final TransactionRequestDto requestDto);

	TransactionResponseDto getTransaction(String jwtToken, final TransactionRequestDto requestDto);
}
