package tr.mhu.core.service.Client.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.exceptions.MhuCoreException;
import tr.mhu.core.domain.rest.RestResponseCode;
import tr.mhu.core.service.Client.RpdPaymentClient;
import tr.mhu.core.service.Util.ServiceUtils;

import java.time.Duration;

/**
 * @author muludag on 12.09.2020
 */
@Slf4j
@Service
public class RpdPaymentClientImpl implements RpdPaymentClient {
	private static final String URL_POSTFIX_TRANSACTION_REPORT = "/api/v3/transactions/report";
	private static final String URL_POSTFIX_TRANSACTION_LIST = "/api/v3/transaction/list";
	private static final String URL_POSTFIX_TRANSACTION = "/api/v3/transaction";
	private static final String URL_POSTFIX_CLIENT = "/api/v3/client";
	@Value("${rpd-payment-api.url:https://sandbox-reporting.rpdpymnt.com}")
	private String url;
	@Value("${rpd-payment-api.connect.timeout:3000}")
	private int connectTimeout;
	@Value("${rpd-payment-api.read.timeout:10000}")
	private int readTimeout;


	@Override
	public MerchantReportResponseDto transactionReport(String jwtToken, MerchantReportRequestDto requestDto) {

		try {
			RestTemplate restTemplate = createRestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", ServiceUtils.tapTopEditStringJwtToken(jwtToken));

			HttpEntity<MerchantReportRequestDto> request = new HttpEntity<MerchantReportRequestDto>(requestDto, headers);
			ResponseEntity<MerchantReportResponseDto> response = restTemplate.postForEntity(url + URL_POSTFIX_TRANSACTION_REPORT, request, MerchantReportResponseDto.class);

			if (response.getStatusCode() == HttpStatus.OK)
				return response.getBody();
			else
				throw new MhuCoreException(RestResponseCode.ERROR);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new MhuCoreException(RestResponseCode.ERROR);

		}

	}

	@Override
	public MerchantListResponseDto transactionList(String jwtToken, MerchantListRequestDto requestDto) {
		try {
			RestTemplate restTemplate = createRestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", ServiceUtils.tapTopEditStringJwtToken(jwtToken));

			HttpEntity<MerchantListRequestDto> request = new HttpEntity<MerchantListRequestDto>(requestDto, headers);

			ResponseEntity<MerchantListResponseDto> response = restTemplate.postForEntity(url + URL_POSTFIX_TRANSACTION_LIST, request, MerchantListResponseDto.class);

			if (response.getStatusCode() == HttpStatus.OK)
				return response.getBody();
			else
				throw new MhuCoreException(RestResponseCode.ERROR);
		} catch (HttpClientErrorException e) {
			log.error(e.getMessage());
			throw new HttpClientErrorException(e.getStatusCode());

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new MhuCoreException(RestResponseCode.ERROR);
		}
	}

	@Override
	public ClientResponseDto getClient(String jwtToken, TransactionRequestDto requestDto) {
		try {
			RestTemplate restTemplate = createRestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", ServiceUtils.tapTopEditStringJwtToken(jwtToken));
			HttpEntity<TransactionRequestDto> request = new HttpEntity<TransactionRequestDto>(requestDto, headers);

			ResponseEntity<ClientResponseDto> response = restTemplate.postForEntity(url + URL_POSTFIX_CLIENT, request, ClientResponseDto.class);

			if (response.getStatusCode() == HttpStatus.OK)
				return response.getBody();
			else
				throw new MhuCoreException(RestResponseCode.ERROR);
		} catch (HttpClientErrorException e) {
			log.error(e.getMessage());
			throw new HttpClientErrorException(e.getStatusCode());

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new MhuCoreException(RestResponseCode.ERROR);
		}
	}

	@Override
	public TransactionResponseDto getTransaction(String jwtToken, TransactionRequestDto requestDto) {
		try {
			RestTemplate restTemplate = createRestTemplate();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", ServiceUtils.tapTopEditStringJwtToken(jwtToken));

			HttpEntity<TransactionRequestDto> request = new HttpEntity<TransactionRequestDto>(requestDto, headers);

			ResponseEntity<TransactionResponseDto> response = restTemplate.postForEntity(url + URL_POSTFIX_TRANSACTION, request, TransactionResponseDto.class);

			if (response.getStatusCode() == HttpStatus.OK)
				return response.getBody();
			else
				throw new MhuCoreException(RestResponseCode.ERROR);
		} catch (HttpClientErrorException e) {
			log.error(e.getMessage());
			throw new HttpClientErrorException(e.getStatusCode());

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new MhuCoreException(RestResponseCode.ERROR);
		}
	}

	@Bean
	private RestTemplate createRestTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofMillis(connectTimeout))
				.setReadTimeout(Duration.ofMillis(readTimeout))
				.build();
	}

}
