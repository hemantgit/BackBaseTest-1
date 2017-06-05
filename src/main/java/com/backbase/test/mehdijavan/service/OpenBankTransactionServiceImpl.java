package com.backbase.test.mehdijavan.service;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;	

import com.backbase.test.mehdijavan.openbank.OBTransactionsList;

@Service
public class OpenBankTransactionServiceImpl implements OpenBankTransactionService {
	private static final String GET_TRANSACTIONS_URL = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/{0}/accounts/{1}/public/transactions";

	@Override
	public OBTransactionsList getTransactionsList(String bankId, String accountId) {
		String url = MessageFormat.format(GET_TRANSACTIONS_URL, bankId, accountId);
		RestTemplate restTemplate = new RestTemplate();
		OBTransactionsList transactionsList = restTemplate.getForObject(url, OBTransactionsList.class);

		return transactionsList;
	}

}
