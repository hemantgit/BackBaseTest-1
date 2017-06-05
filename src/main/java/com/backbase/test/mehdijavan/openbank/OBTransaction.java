package com.backbase.test.mehdijavan.openbank;

public class OBTransaction {
	private String id;
	private OBAccount this_account;
	private OBOtherAccount other_account;
	private OBTransactionDetails details;
	private OBTransactionMetadata metadata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OBAccount getThis_account() {
		return this_account;
	}

	public void setThis_account(OBAccount this_account) {
		this.this_account = this_account;
	}

	public OBOtherAccount getOther_account() {
		return other_account;
	}

	public void setOther_account(OBOtherAccount other_account) {
		this.other_account = other_account;
	}

	public OBTransactionDetails getDetails() {
		return details;
	}

	public void setDetails(OBTransactionDetails details) {
		this.details = details;
	}

	public OBTransactionMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(OBTransactionMetadata metadata) {
		this.metadata = metadata;
	}

}
