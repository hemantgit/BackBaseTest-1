package com.backbase.test.mehdijavan.openbank;

public class OBTransactionDetails {
	private String type; // cash
	private String description; // transaction description
	private String posted; // 2012-03-07T00:00:00.001Z
	private String completed; // 2012-03-07T00:00:00.001Z
	private OBBalance new_balance;
	private OBAmount value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosted() {
		return posted;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public OBBalance getNew_balance() {
		return new_balance;
	}

	public void setNew_balance(OBBalance new_balance) {
		this.new_balance = new_balance;
	}

	public OBAmount getValue() {
		return value;
	}

	public void setValue(OBAmount value) {
		this.value = value;
	}

}
