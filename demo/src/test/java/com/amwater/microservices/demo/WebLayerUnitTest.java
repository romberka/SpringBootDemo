package com.amwater.microservices.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amwater.microservices.demo.controller.CxfController;

// Example of where just the web layer is verified. The server is not started.
@RunWith(SpringRunner.class)
@WebMvcTest(value=CxfController.class, secure=false) // Unit testing the web layer. Instantiates just the CxfController class instead of the entire application context.
//@AutoConfigureMockMvc(secure=false) // Auto configure MockMvc without Spring Security. The full Spring application context is started, but without the server. Uncomment if you need the entire application context started.
@ActiveProfiles("dev")
public class WebLayerUnitTest {

	@Autowired // MockMvc is the main entry point for server-side Spring MVC test support. It allows us to execute requests against the test context.
	private MockMvc mockMvc;
	
	@MockBean // Mock and inject the mocked service into the controller
	private ContractAccountService contractAccountServiceMock;
	
	private Account account; // Mock data
	
	@Before
    public void setUp() {
		// Add mock data
		account = new Account();
		account.setAccountId(new AccountId("1"));
		account.setAccountClassDescription("Mock test");
		account.setCustomerType("P");
		account.setFirstName("John");
		account.setLastName("Doe");
    }
	
	@Test
	public void testAccount() throws Exception {
		assertThat(contractAccountServiceMock).isNotNull();
		
		// Mock the getAccount method and return the mock account data
		when(contractAccountServiceMock.getAccount(anyString())).thenReturn(account);
		
		// Invoke the controller with mocked service 
		mockMvc.perform(MockMvcRequestBuilders.get("/account/" + account.getAccountId().getAccountNumber()).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.accountClassDescription", is("Mock test")))
			.andExpect(jsonPath("$.customerType", is("P")))
			.andExpect(jsonPath("$.formattedFullName", is("John Doe")))
			.andDo(print());
    }
}