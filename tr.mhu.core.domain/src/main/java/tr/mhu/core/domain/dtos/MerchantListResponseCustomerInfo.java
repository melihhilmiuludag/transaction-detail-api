package tr.mhu.core.domain.dtos;

import lombok.Data;



/**
 * @author muludag on 13.09.2020
 */
@Data
public class MerchantListResponseCustomerInfo {
	String number;
	String email;
	String billingFirstName;
	String billingLastName;
}
