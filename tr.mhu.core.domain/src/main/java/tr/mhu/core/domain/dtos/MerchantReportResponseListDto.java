package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 12.09.2020
 */
@Data
public class MerchantReportResponseListDto {
	int count;
	int total;
	String currency;
}
