package tr.mhu.core.domain.dtos;

import lombok.Data;
import tr.mhu.core.domain.util.RequestDetail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class TransactionRequestDto implements RequestDetail {
	@NotNull
	@NotEmpty
	String transactionId;
}
