package tr.mhu.core.domain.dtos;

import lombok.Data;
import tr.mhu.core.domain.enums.*;
import tr.mhu.core.domain.util.RequestDetail;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * @author muludag on 12.09.2020
 */
@Data
public class MerchantListRequestDto implements RequestDetail {
	String fromDate;
	String toDate;
	EStatus status;
	EOperation operation;
	Integer merchantId;
	Integer acquirerId;
	EPayment paymentMethod;
	EErrorCode errorCode;
	EFilterField filterField;
	String filterValue;
	Integer page;
}
