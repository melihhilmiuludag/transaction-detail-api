package tr.mhu.core.domain.dtos;

import lombok.Data;

/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantListMerchantDto {
	Integer id;
	String name;
	Boolean allowPartialRefund;
	Boolean allowPartialCapture;
}
