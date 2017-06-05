package com.backbase.test.mehdijavan.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class TransactionsFilter {
	private BigDecimal amountRangeFrom;
	private BigDecimal amountRangeTo;
	private String counterpartyAccountNumber;
	private String query;
	private String categoryIds;
	private Long dateRangeFrom;
	private Long dateRangeTo;
	private String sort;
	private Integer from;
	private Integer length;

	public BigDecimal getAmountRangeFrom() {
		return amountRangeFrom;
	}

	public void setAmountRangeFrom(BigDecimal amountRangeFrom) {
		this.amountRangeFrom = amountRangeFrom;
	}

	public BigDecimal getAmountRangeTo() {
		return amountRangeTo;
	}

	public void setAmountRangeTo(BigDecimal amountRangeTo) {
		this.amountRangeTo = amountRangeTo;
	}

	public String getCounterpartyAccountNumber() {
		return counterpartyAccountNumber;
	}

	public void setCounterpartyAccountNumber(String counterpartyAccountNumber) {
		this.counterpartyAccountNumber = counterpartyAccountNumber;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Long getDateRangeFrom() {
		return dateRangeFrom;
	}

	public void setDateRangeFrom(Long dateRangeFrom) {
		this.dateRangeFrom = dateRangeFrom;
	}

	public Long getDateRangeTo() {
		return dateRangeTo;
	}

	public void setDateRangeTo(Long dateRangeTo) {
		this.dateRangeTo = dateRangeTo;
	}

	@NotNull
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@NotNull
	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	@NotNull
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
