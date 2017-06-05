package com.backbase.test.mehdijavan.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.backbase.test.mehdijavan.dto.Transaction;
import com.backbase.test.mehdijavan.openbank.OBTransaction;

public class OpenBankToBackBaseConverter {
	private static final OpenBankToBackBaseConverter instance = new OpenBankToBackBaseConverter();

	private OpenBankToBackBaseConverter() {

	}

	public static OpenBankToBackBaseConverter getInstance() {
		return instance;
	}

	public Transaction convertToBackBase(OBTransaction obTransaction) {
		Transaction transaction = new Transaction();

		transaction.setId(obTransaction.getId());
		transaction.setAccountId(obTransaction.getThis_account().getId());
		transaction.setCounterpartyAccount(obTransaction.getOther_account().getNumber());
		transaction.setCounterpartyName(obTransaction.getOther_account().getHolder().getName());
		transaction.setCounterPartyLogoPath(obTransaction.getOther_account().getMetadata().getImage_URL());
		transaction.setInstructedAmount(obTransaction.getDetails().getValue().getAmount());
		transaction.setInstructedCurrency(obTransaction.getDetails().getValue().getCurrency());
		transaction.setTransactionAmount(obTransaction.getDetails().getValue().getAmount());
		transaction.setTransactionCurrency(obTransaction.getDetails().getValue().getCurrency());
		transaction.setTransactionType(obTransaction.getDetails().getType());
		transaction.setDescription(obTransaction.getDetails().getDescription());
		transaction.setBookingDateTime(convertToBackBaseDate(obTransaction.getDetails().getCompleted()));

		return transaction;
	}

	public String convertToOpenBankDate(Long date) {
		if(date == null)
			return null;
		
		Date javaDate = new java.util.Date(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String openBankDate = dateFormat.format(javaDate);

		return openBankDate;
	}

	public Long convertToBackBaseDate(String date) {
		if(date == null)
			return null;
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date javaDate = dateFormat.parse(date);
			return javaDate.getTime();
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
