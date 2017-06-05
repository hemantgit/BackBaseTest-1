package com.backbase.test.mehdijavan.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.backbase.test.mehdijavan.config.GeneralConstants;
import com.backbase.test.mehdijavan.openbank.OBAccount;
import com.backbase.test.mehdijavan.openbank.OBAccountHolder;
import com.backbase.test.mehdijavan.openbank.OBAccountMetadata;
import com.backbase.test.mehdijavan.openbank.OBAmount;
import com.backbase.test.mehdijavan.openbank.OBOtherAccount;
import com.backbase.test.mehdijavan.openbank.OBTransaction;
import com.backbase.test.mehdijavan.openbank.OBTransactionDetails;
import com.backbase.test.mehdijavan.openbank.OBTransactionsList;
import com.backbase.test.mehdijavan.service.OpenBankTransactionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config-test.xml")
@WebAppConfiguration
public class TransactionControllerTest {
	@Autowired
	private WebApplicationContext context;


    private MockMvc mockMvc;

    @Mock
    private OpenBankTransactionService openBankTransactionService;

    @InjectMocks
    private TransactionController transactionController;

	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(transactionController)
                .build();
    }	

	@Test
	public void testOneRecord() throws Exception {
		OBTransactionsList transactionsList = createSampleTransactions();
		
		when(openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, "100"))
			.thenReturn(transactionsList); 
		
		mockMvc
			.perform(get("/v1/current-accounts/100/transactions/?sort=InstructedAmount&from=0&length=1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].id", is("2")))
			.andExpect(jsonPath("$[0].accountId", is("100")))
			.andExpect(jsonPath("$[0].instructedAmount", is(-120)));
		
		verify(openBankTransactionService, times(1)).getTransactionsList(GeneralConstants.BANK_ID, "100");
        verifyNoMoreInteractions(openBankTransactionService);
	}

	@Test
	public void testFilterByType() throws Exception {
		OBTransactionsList transactionsList = createSampleTransactions();
		
		when(openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, "100"))
			.thenReturn(transactionsList); 
		
		mockMvc
			.perform(get("/v1/current-accounts/100/transactions/Transfer"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(5)))
			.andExpect(jsonPath("$[0].transactionType", is("Transfer")))
			.andExpect(jsonPath("$[1].transactionType", is("Transfer")))
			.andExpect(jsonPath("$[2].transactionType", is("Transfer")))
			.andExpect(jsonPath("$[3].transactionType", is("Transfer")))
			.andExpect(jsonPath("$[4].transactionType", is("Transfer")));
		
		verify(openBankTransactionService, times(1)).getTransactionsList(GeneralConstants.BANK_ID, "100");
        verifyNoMoreInteractions(openBankTransactionService);
	}

	@Test
	public void testTotal() throws Exception {
		OBTransactionsList transactionsList = createSampleTransactions();
		
		when(openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, "100"))
			.thenReturn(transactionsList); 
		
		mockMvc
			.perform(get("/v1/current-accounts/100/transactions/Transfer/total"))			
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.GBP", is(100)))
			.andExpect(jsonPath("$.EUR", is(290)));
		
		verify(openBankTransactionService, times(1)).getTransactionsList(GeneralConstants.BANK_ID, "100");
        verifyNoMoreInteractions(openBankTransactionService);
	}

	private OBTransactionsList createSampleTransactions() {
		OBTransactionsList transactionsList = new OBTransactionsList();
		List<OBTransaction> transactions = new ArrayList<OBTransaction>();

		OBAccount account100 = new OBAccount();
		account100.setId("100");

		OBOtherAccount otherAccount2000 = new OBOtherAccount();
		otherAccount2000.setHolder(new OBAccountHolder("Mehdi", true));
		otherAccount2000.setNumber("2000");
		otherAccount2000.setMetadata(new OBAccountMetadata());
		otherAccount2000.getMetadata().setImage_URL("some_image.jpg");

		OBOtherAccount otherAccount2100 = new OBOtherAccount();
		otherAccount2100.setHolder(new OBAccountHolder("John", true));
		otherAccount2100.setNumber("2100");
		otherAccount2100.setMetadata(new OBAccountMetadata());
		otherAccount2100.getMetadata().setImage_URL("some_image.jpg");

		OBOtherAccount otherAccount2200 = new OBOtherAccount();
		otherAccount2200.setHolder(new OBAccountHolder("Jack", true));
		otherAccount2200.setNumber("2200");
		otherAccount2200.setMetadata(new OBAccountMetadata());
		otherAccount2200.getMetadata().setImage_URL("some_image.jpg");

		/*******************************************************/
		OBTransaction transaction = new OBTransaction();
		
		OBTransactionDetails details = new OBTransactionDetails();
		details.setValue(new OBAmount("EUR", BigDecimal.valueOf(150)));
		details.setType("Transfer");
		details.setDescription("This is description");
		details.setCompleted("2017-05-01T08:00:00Z");
		
		transaction.setId("1");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2000);
		transaction.setDetails(details);
		
		transactions.add(transaction);
		
		/*******************************************************/
		transaction = new OBTransaction();
		
		details = new OBTransactionDetails();
		details.setValue(new OBAmount("EUR", BigDecimal.valueOf(-120)));
		details.setType("Transfer");
		details.setDescription("This is another description");
		details.setCompleted("2017-05-02T08:00:00Z");
		
		transaction.setId("2");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2100);
		transaction.setDetails(details);
		
		transactions.add(transaction);
		
		/*******************************************************/
		transaction = new OBTransaction();
		
		details = new OBTransactionDetails();
		details.setValue(new OBAmount("GBP", BigDecimal.valueOf(25)));
		details.setType("Charity");
		details.setDescription("This is another description");
		details.setCompleted("2017-05-03T08:00:00Z");
		
		transaction.setId("3");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2200);
		transaction.setDetails(details);
		
		transactions.add(transaction);
		
		/*******************************************************/
		transaction = new OBTransaction();
		
		details = new OBTransactionDetails();
		details.setValue(new OBAmount("EUR", BigDecimal.valueOf(160)));
		details.setType("Transfer");
		details.setDescription("This is another description");
		details.setCompleted("2017-05-03T08:00:00Z");
		
		transaction.setId("4");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2000);
		transaction.setDetails(details);
		
		transactions.add(transaction);
		
		/*******************************************************/
		transaction = new OBTransaction();
		
		details = new OBTransactionDetails();
		details.setValue(new OBAmount("GBP", BigDecimal.valueOf(100)));
		details.setType("Transfer");
		details.setDescription("This is another description");
		details.setCompleted("2017-05-03T08:00:00Z");
		
		transaction.setId("5");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2000);
		transaction.setDetails(details);
		
		transactions.add(transaction);
		
		/*******************************************************/
		transaction = new OBTransaction();
		
		details = new OBTransactionDetails();
		details.setValue(new OBAmount("EUR", BigDecimal.valueOf(100)));
		details.setType("Transfer");
		details.setDescription("This is another description");
		details.setCompleted("2017-05-03T08:00:00Z");
		
		transaction.setId("6");
		transaction.setThis_account(account100);
		transaction.setOther_account(otherAccount2000);
		transaction.setDetails(details);
		
		transactions.add(transaction);

		transactionsList.setTransactions(transactions);
		return transactionsList;
	}

}
