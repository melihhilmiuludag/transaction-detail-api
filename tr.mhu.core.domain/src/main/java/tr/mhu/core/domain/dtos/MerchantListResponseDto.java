package tr.mhu.core.domain.dtos;

import lombok.Data;

import java.util.List;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantListResponseDto {
	Integer per_page;
	Integer current_page;
	String next_page_url;
	String prev_page_url;
	Integer from;
	Integer to;
	List<MerchantListResponseDataDto> data;
}
