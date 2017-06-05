package com.backbase.test.mehdijavan.openbank;

import java.math.BigDecimal;

public class OBAmount {
	private String currency;
	private BigDecimal amount;

	
	public OBAmount() {
		super();
	}

	public OBAmount(String currency, BigDecimal amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
