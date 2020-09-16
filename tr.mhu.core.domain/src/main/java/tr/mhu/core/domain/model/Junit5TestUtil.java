package tr.mhu.core.domain.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.entites.Register;
import tr.mhu.core.domain.util.RequestHeaderDto;
import tr.mhu.core.domain.util.RestRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author muludag on 16.09.2020
 */
@Slf4j
public class Junit5TestUtil {

	public static int listSize = 10;

	public static Register eRegister() {
		Register r = new Register();
		r.setId("ID-123");
		r.setToken("eYxyzt1.jwt-token");
		r.setSystemName("mhu-core-test");
		r.setExpireDate(LocalDateTime.now().plusMinutes(10));
		r.setCreatedDate(LocalDateTime.now());
		return r;
	}

	public static RegisterResponseDto convertFromRegister(Register e) {
		RegisterResponseDto dto = new RegisterResponseDto(e.getToken(), e.getSystemName());
		if (!(Duration.between(LocalDateTime.now(), e.getExpireDate()).toMinutes() > 1)) {
			log.error("expire date");
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}
		return dto;
	}

	public static RegisterResponseDto dRegisterResponseDto() {
		return new RegisterResponseDto(eRegister().getToken(), eRegister().getSystemName());
	}
	public static RegisterRequestDto dRegisterRequestDto() {
		RegisterRequestDto requestDto=new RegisterRequestDto ();
		requestDto.setSystemName(eRegister().getSystemName());
		requestDto.setToken(eRegister().getToken());
		return requestDto;
	}

	public static MerchantReportResponseDto dMerchantReportResponseDto() {
		return new MerchantReportResponseDto(eRegister().getSystemName(), lMerchantReportResponseListDtoList());
	}

	public static List<MerchantReportResponseListDto> lMerchantReportResponseListDtoList() {
		MerchantReportResponseListDto m = new MerchantReportResponseListDto();
		return Collections.nCopies(listSize, m);
	}

	public static RestRequest<RequestHeaderDto, MerchantReportRequestDto> rRequestMerchantReportRequestDto() {
		RestRequest<RequestHeaderDto, MerchantReportRequestDto> req = new RestRequest<>();
		RequestHeaderDto h = new RequestHeaderDto();
		MerchantReportRequestDto r = new MerchantReportRequestDto();
		h.setJwtToken(eRegister().getToken());
		h.setSystem(eRegister().getSystemName());
		r.setAcquirer(1);
		r.setFromDate("2020-02-02");
		r.setToDate("2010-02-02");
		req.setDetail(r);
		req.setHeader(h);
		return req;
	}

	public static RestRequest<RequestHeaderDto, MerchantListRequestDto> rRequestMerchantListRequestDto() {
		RestRequest<RequestHeaderDto, MerchantListRequestDto> req = new RestRequest<>();
		RequestHeaderDto h = new RequestHeaderDto();
		MerchantListRequestDto r = new MerchantListRequestDto();
		h.setJwtToken(eRegister().getToken());
		h.setSystem(eRegister().getSystemName());
		r.setFromDate("2020-02-02");
		r.setToDate("2010-02-02");
		req.setDetail(r);
		req.setHeader(h);
		return req;
	}

	public static RestRequest<RequestHeaderDto, TransactionRequestDto> rRequestTransactionRequestDto() {
		RestRequest<RequestHeaderDto, TransactionRequestDto> req = new RestRequest<>();
		RequestHeaderDto h = new RequestHeaderDto();
		TransactionRequestDto r = new TransactionRequestDto();
		h.setJwtToken(eRegister().getToken());
		h.setSystem(eRegister().getSystemName());
		r.setTransactionId("TRANSACTION-123-456");
		req.setDetail(r);
		req.setHeader(h);
		return req;
	}

	public static RestRequest<RequestHeaderDto, TransactionRequestDto> rTransactionRequestDto() {
		RestRequest<RequestHeaderDto, TransactionRequestDto> req = new RestRequest<>();
		RequestHeaderDto h = new RequestHeaderDto();
		TransactionRequestDto r = new TransactionRequestDto();
		h.setJwtToken(eRegister().getToken());
		h.setSystem(eRegister().getSystemName());
		r.setTransactionId("TRANSACTION-123-456");
		req.setDetail(r);
		req.setHeader(h);
		return req;
	}

	public static MerchantListResponseDto dMerchantListResponseDto() {
		MerchantListResponseDto m = new MerchantListResponseDto();
		m.setData(Collections.nCopies(listSize, new MerchantListResponseDataDto()));
		return m;
	}

	public static ClientResponseDto dClientResponseDto() {
		return new ClientResponseDto();
	}

	public static TransactionResponseDto dTransactionResponseDto() {
		return new TransactionResponseDto();
	}


}
