package com.backbase.test.mehdijavan.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backbase.test.mehdijavan.config.GeneralConstants;
import com.backbase.test.mehdijavan.converters.OpenBankToBackBaseConverter;
import com.backbase.test.mehdijavan.dto.Transaction;
import com.backbase.test.mehdijavan.dto.TransactionsFilter;
import com.backbase.test.mehdijavan.openbank.OBTransaction;
import com.backbase.test.mehdijavan.openbank.OBTransactionsList;
import com.backbase.test.mehdijavan.service.OpenBankTransactionService;
import com.backbase.test.mehdijavan.utils.FieldComparator;

@Controller
@RequestMapping(value = "v1/current-accounts")
public class TransactionController {
	@Autowired
	private OpenBankTransactionService openBankTransactionService;

	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}/transactions")
	public @ResponseBody List<Transaction> transactions(
			@PathVariable("accountId") String accountId, 
			@Valid TransactionsFilter filter) {

		OBTransactionsList transactionsList = openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, accountId);
		OpenBankToBackBaseConverter converter = OpenBankToBackBaseConverter.getInstance();

		List<Transaction> list = new ArrayList<Transaction>();
		for (OBTransaction obTransaction : transactionsList.getTransactions()) {
			Transaction transaction = converter.convertToBackBase(obTransaction);

			if (filter == null || applyFilter(transaction, filter)) 
				list.add(transaction);
		}

		applySort(filter, list);

		List<Transaction> subList = applyPaging(filter, list);

		return subList;
	}

	private void applySort(TransactionsFilter filter, List<Transaction> list) {
		if (filter != null && filter.getSort() != null) {
			Collections.sort(list, new FieldComparator(filter.getSort()));
		}
	}

	private List<Transaction> applyPaging(TransactionsFilter filter, List<Transaction> list) {
		int fromIndex;
		if (filter != null && filter.getFrom() != null)
			fromIndex = filter.getFrom();
		else
			fromIndex = 0;

		int toIndex;
		if (filter != null && filter.getLength() != null) {
			toIndex = fromIndex + filter.getLength();
			if(toIndex > list.size())
				toIndex = list.size();
		}
		else
			toIndex = list.size();

		List<Transaction> subList = list.subList(fromIndex, toIndex);
		return subList;
	}

	private boolean applyFilter(Transaction transaction, TransactionsFilter filter) {
		if (filter.getAmountRangeFrom() != null
				&& (transaction.getTransactionAmount() == null || filter.getAmountRangeFrom().compareTo(transaction.getTransactionAmount()) > 0))
			return false;

		if (filter.getAmountRangeTo() != null
				&& (transaction.getTransactionAmount() == null || filter.getAmountRangeTo().compareTo(transaction.getTransactionAmount()) < 0))
			return false;

		if (filter.getCategoryIds() != null
				&& (transaction.getCategoryId() == null || !("," + filter.getCategoryIds() + ",").contains("," + transaction.getCategoryId() + ",")))
			return false;

		if (filter.getCounterpartyAccountNumber() != null && !filter.getCounterpartyAccountNumber().equals(transaction.getCounterpartyAccount()))
			return false;

		if (filter.getDateRangeFrom() != null
				&& (transaction.getBookingDateTime() == null || filter.getDateRangeFrom().compareTo(transaction.getBookingDateTime()) > 0))
			return false;

		if (filter.getDateRangeTo() != null
				&& (transaction.getBookingDateTime() == null || filter.getDateRangeTo().compareTo(transaction.getBookingDateTime()) < 0))
			return false;

		if (filter.getQuery() != null && !((transaction.getCounterpartyName() != null && transaction.getCounterpartyName().contains(filter.getQuery()))
				|| (transaction.getDescription() != null && transaction.getDescription().contains(filter.getQuery()))))
			return false;
		
		return true;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}/transactions/{type}")
	public @ResponseBody List<Transaction> transactionsByType(@PathVariable("accountId") String accountId, @PathVariable("type") String type) {
		OBTransactionsList transactionsList = openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, accountId);

		List<Transaction> list = new ArrayList<Transaction>();
		OpenBankToBackBaseConverter converter = OpenBankToBackBaseConverter.getInstance();
		for (OBTransaction obTransaction : transactionsList.getTransactions())
			if (Objects.equals(type, obTransaction.getDetails().getType()))
				list.add(converter.convertToBackBase(obTransaction));

		return list;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}/transactions/{type}/total")
	public @ResponseBody Map<String, BigDecimal> totalAmount(@PathVariable("accountId") String accountId, @PathVariable("type") String type) {
		OBTransactionsList transactionsList = openBankTransactionService.getTransactionsList(GeneralConstants.BANK_ID, accountId);

		Map<String, BigDecimal> totalAmounts = new HashMap<String, BigDecimal>();
		
		for (OBTransaction obTransaction : transactionsList.getTransactions())
			if (Objects.equals(type, obTransaction.getDetails().getType())) {
				BigDecimal total = totalAmounts.get(obTransaction.getDetails().getValue().getCurrency());
				
				if(total == null)
					total = new BigDecimal(0);
				
				total = total.add(obTransaction.getDetails().getValue().getAmount());
				
				totalAmounts.put(obTransaction.getDetails().getValue().getCurrency(), total);
			}

		return totalAmounts;
	}
}
