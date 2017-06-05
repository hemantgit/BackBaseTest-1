package com.backbase.test.mehdijavan.openbank;

import java.util.List;

public class OBAccount {
	private String id;
	private List<OBAccountHolder> holders;
	private String number;
	private String kind;
	private String IBAN;
	private String swift_bic;
	private OBBank bank;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<OBAccountHolder> getHolders() {
		return holders;
	}

	public void setHolders(List<OBAccountHolder> holders) {
		this.holders = holders;
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
}
