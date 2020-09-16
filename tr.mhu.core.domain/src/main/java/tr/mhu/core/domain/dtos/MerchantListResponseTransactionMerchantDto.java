package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantListResponseTransactionMerchantDto {
	String referenceNo;
	String status;
	String customData;
	String operation;
	String type;
	String message;
	String created_at;
	String transactionId;
}
