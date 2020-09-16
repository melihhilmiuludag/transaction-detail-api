package tr.mhu.core.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import tr.mhu.core.data.RegisterRepository;
import tr.mhu.core.domain.dtos.*;
import tr.mhu.core.domain.model.Junit5TestUtil;
import tr.mhu.core.service.Client.RpdPaymentClient;
import tr.mhu.core.service.RegisterService;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author muludag on 16.09.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class MerchantServiceImplTest {

	@Value("${mhu-core.register.expire.min:10}")
	static long expireMin;
	@InjectMocks
	MerchantServiceImpl merchantService;
	@Mock
	RpdPaymentClient rpdPaymentClient;
	@Mock
	RegisterService registerService;
	@Mock
	RegisterRepository registerRepository;


	//TODO: Junit5TestUtil class has mock entites, dto, request etc.

	@BeforeEach
	void setUp() {
		log.debug("test started!");
		MockitoAnnotations.initMocks(this);
		//TODO: below Register test methods.
		Mockito.when(registerRepository.findById(Mockito.anyString())).thenReturn(Optional.of(Junit5TestUtil.eRegister()));
		Mockito.when(registerService.getRegister(Mockito.anyString())).thenReturn(Junit5TestUtil.dRegisterResponseDto());
	}

	@AfterEach
	void tearDown() {
		log.debug("test ended!");
	}

	@Test
	void transactionReport() {

		Mockito.when(rpdPaymentClient.transactionReport(Mockito.anyString(), Mockito.any())).thenReturn(Junit5TestUtil.dMerchantReportResponseDto());
		Mockito.when(merchantService.transactionReport(Junit5TestUtil.rRequestMerchantReportRequestDto())).thenReturn(Junit5TestUtil.dMerchantReportResponseDto());

		MerchantReportResponseDto returnService = merchantService.transactionReport(Junit5TestUtil.rRequestMerchantReportRequestDto());

		Assert.assertNotNull(returnService);
		Assert.assertEquals(Junit5TestUtil.listSize, returnService.getResponse().size());

		Mockito.verify(rpdPaymentClient, Mockito.times(1)).transactionReport(Mockito.anyString(), Mockito.any());

		log.info("successfully completed bro!");
	}

	@Test
	void transactionList() {

		Mockito.when(rpdPaymentClient.transactionList(Mockito.anyString(), Mockito.any())).thenReturn(Junit5TestUtil.dMerchantListResponseDto());
		Mockito.when(merchantService.transactionList(Junit5TestUtil.rRequestMerchantListRequestDto())).thenReturn(Junit5TestUtil.dMerchantListResponseDto());

		MerchantListResponseDto returnService = merchantService.transactionList(Junit5TestUtil.rRequestMerchantListRequestDto());

		Assert.assertNotNull(returnService);
		Assert.assertEquals(Junit5TestUtil.listSize, returnService.getData().size());
		//TODO: Let's imagine that there was a need :)
		Map<String, MerchantListResponseDataDto> map = returnService.getData().stream()
				.collect(Collectors.toMap(cityDto -> String.valueOf(UUID.randomUUID()), MerchantListResponseDataDto::new));

		Assert.assertEquals(Junit5TestUtil.listSize, map.size());

		//possible to increase options
		log.info("successfully completed bro!");

	}

	@Test
	void getClient() {

		Mockito.when(rpdPaymentClient.getClient(Mockito.anyString(), Mockito.any())).thenReturn(Junit5TestUtil.dClientResponseDto());
		Mockito.when(merchantService.getClient(Junit5TestUtil.rRequestTransactionRequestDto())).thenReturn(Junit5TestUtil.dClientResponseDto());

		ClientResponseDto returnService = merchantService.getClient(Junit5TestUtil.rRequestTransactionRequestDto());

		Assert.assertNotNull(returnService);
		log.info("successfully completed bro!");
	}

	@Test
	void getTransaction() {

		Mockito.when(rpdPaymentClient.getTransaction(Mockito.anyString(), Mockito.any())).thenReturn(Junit5TestUtil.dTransactionResponseDto());
		Mockito.when(merchantService.getTransaction(Junit5TestUtil.rRequestTransactionRequestDto())).thenReturn(Junit5TestUtil.dTransactionResponseDto());

		TransactionResponseDto returnService = merchantService.getTransaction(Junit5TestUtil.rRequestTransactionRequestDto());

		Assert.assertNotNull(returnService);
		Assert.assertTrue(returnService.getAcquirerTransactions().getCode() == null);
		Assert.assertTrue(returnService.getCustomerInfo().getBillingAddress1().equals(""));

		log.info("successfully completed bro!");
	}
}