package com.backbase.test.mehdijavan.service;

import com.backbase.test.mehdijavan.openbank.OBTransactionsList;

public interface OpenBankTransactionService {
	OBTransactionsList getTransactionsList(String bankId, String accountId);
}
