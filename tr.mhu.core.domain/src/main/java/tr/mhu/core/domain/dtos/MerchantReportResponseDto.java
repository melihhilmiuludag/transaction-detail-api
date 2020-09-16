package tr.mhu.core.domain.dtos;

import lombok.Value;

import java.util.List;

/**
 * @author muludag on 12.09.2020
 */
@Value
public class MerchantReportResponseDto {
	String status;
	List<MerchantReportResponseListDto> response;
}
