package tr.mhu.core.domain.dtos;

import lombok.Data;


/**
 * @author muludag on 13.09.2020
 */
@Data
public class CustomerInfo {
	Integer id;
	String created_at;
	String updated_at;
	String deleted_at;
	String number;
	Integer expiryMonth;
	Integer expiryYear;
	Integer startMonth;
	Integer startYear;
	String issueNumber;
	String email;
	String birthday;
	String gender;
	String billingTitle;
	String billingFirstName;
	String billingLastName;
	String billingCompany;
	String billingAddress1;
	String billingAddress2;
	String billingCity;
	String billingPostcode;
	String billingState;
	String billingCountry;
	String billingPhone;
	String billingFax;
	String shippingTitle;
	String shippingFirstName;
	String shippingLastName;
	String shippingCompany;
	String shippingAddress1;
	String shippingAddress2;
	String shippingCity;
	String shippingPostcode;
	String shippingState;
	String shippingCountry;
	String shippingPhone;
	String shippingFax;
}
