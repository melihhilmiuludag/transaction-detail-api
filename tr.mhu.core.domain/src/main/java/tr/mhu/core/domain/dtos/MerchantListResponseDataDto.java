package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantListResponseDataDto {
	MerchantListResponseCustomerInfo customerInfo;
	MerchantListResponseFxDto fx;
	MerchantListMerchantDto merchant;
	MerchantListIpnDto ipn;
	MerchantListResponseTransactionDto transaction;
	MerchantListResponseAcquirerDto acquirer;
	Boolean refundable;
	String updated_at;
	String created_at;

	public MerchantListResponseDataDto(MerchantListResponseDataDto merchantListResponseDataDto) {
	}

	public MerchantListResponseDataDto() {
	}
}
