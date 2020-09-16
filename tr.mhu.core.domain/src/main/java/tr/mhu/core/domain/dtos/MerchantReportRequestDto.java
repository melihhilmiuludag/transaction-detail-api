package tr.mhu.core.domain.dtos;

import lombok.Data;
import tr.mhu.core.domain.util.RequestDetail;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * @author muludag on 12.09.2020
 */
@Data
public class MerchantReportRequestDto implements RequestDetail {
	@NotNull
	String fromDate;
	@NotNull
	String toDate;
	Integer merchant;
	Integer acquirer;
}
