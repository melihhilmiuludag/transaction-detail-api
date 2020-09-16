package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantResponseDto {
	String referenceNo;
	Integer merchantId;
	String status;
	String channel;
	String customData;
	String chainId;
	String type;
	Integer agentInfoId;
	String operation;
	String updated_at;
	String created_at;
	Integer id;
	Integer fxTransactionId;
	Integer acquirerTransactionId;
	String code;
	String message;
	String transactionId;
	AgentResponseDto agent;
}
