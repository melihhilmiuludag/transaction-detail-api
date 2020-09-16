package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class TransactionResponseDto {
	TransactionResponseFxDto fx;
	CustomerInfo customerInfo;
	TransactionResponseMerchantDto merchant;
	MerchantListResponseAcquirerDto acquirerTransactions;
	MerchantTransactionResponseDto transaction;
}
