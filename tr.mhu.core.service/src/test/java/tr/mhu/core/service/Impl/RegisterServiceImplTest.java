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
import tr.mhu.core.data.RegisterRepository;
import tr.mhu.core.domain.dtos.RegisterResponseDto;
import tr.mhu.core.domain.entites.Register;
import tr.mhu.core.domain.model.Junit5TestUtil;

import java.util.Optional;

/**
 * @author muludag on 16.09.2020
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
class RegisterServiceImplTest {
	@Mock
	RegisterRepository registerRepository;
	@InjectMocks
	RegisterServiceImpl registerService;


	//TODO: Junit5TestUtil class has mock entites, dto, request etc.

	@BeforeEach
	void setUp() {
		log.debug("test started!");
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() {
		log.debug("test ended!");
	}

	@Test
	void toRegister() {
		Register register = registerService.toRegister(Mockito.anyString(), Mockito.anyString());
		Assert.assertNotNull(register);
	}


}