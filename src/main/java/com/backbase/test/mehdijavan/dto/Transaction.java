package com.backbase.test.mehdijavan.dto;

import java.math.BigDecimal;

public class Transaction {
	private String id;
	private String accountId; // Account Id.
	private String categoryId; // Category within which the transaction falls.
	private Long bookingDateTime; // Timestamp of when booked.
	private String counterpartyAccount; // The name of the counterparty's account.
	private String counterpartyName; // The name of the counterparty.
	private String counterPartyLogoPath; // Path to a logo corresponding to the counterparty.
	private BigDecimal instructedAmount; // The amount to be transferred.
	private String instructedCurrency; // The currency in which the transfer is to be made.
	private BigDecimal transactionAmount; // The amount actually transferred.
	private String transactionCurrency; // The currency in which the transfer was actually made.
	private String transactionType; // Transaction type as defined by the backend.
	private Address address; // An address object holding the counterparty's address.
	private Location location; // A location object holding the counterparty's coordinates.
	private String merchantType; // Merchant type.
	private String remittanceInformation; // Not used.
	private String creditDebitIndicator; // Whether the account was debited (DBIT) or credited (CRDT).
	private String description; // Any extra free text describing the transaction.
	
	public Transaction() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(Long bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}

	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public String getCounterPartyLogoPath() {
		return counterPartyLogoPath;
	}

	public void setCounterPartyLogoPath(String counterPartyLogoPath) {
		this.counterPartyLogoPath = counterPartyLogoPath;
	}

	public BigDecimal getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(BigDecimal instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	public String getInstructedCurrency() {
		return instructedCurrency;
	}

	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getRemittanceInformation() {
		return remittanceInformation;
	}

	public void setRemittanceInformation(String remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}

	public String getCreditDebitIndicator() {
		return creditDebitIndicator;
	}

	public void setCreditDebitIndicator(String creditDebitIndicator) {
		this.creditDebitIndicator = creditDebitIndicator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
