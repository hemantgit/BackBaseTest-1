package com.backbase.test.mehdijavan.openbank;

public class OBOtherAccount {
	private String id;
	private OBAccountHolder holder;
	private String number;
	private String kind;
	private String IBAN;
	private String swift_bic;
	private OBBank bank;
	private OBAccountMetadata metadata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OBAccountHolder getHolder() {
		return holder;
	}

	public void setHolder(OBAccountHolder holder) {
		this.holder = holder;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getSwift_bic() {
		return swift_bic;
	}

	public void setSwift_bic(String swift_bic) {
		this.swift_bic = swift_bic;
	}

	public OBBank getBank() {
		return bank;
	}

	public void setBank(OBBank bank) {
		this.bank = bank;
	}

	public OBAccountMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(OBAccountMetadata metadata) {
		this.metadata = metadata;
	}
}
