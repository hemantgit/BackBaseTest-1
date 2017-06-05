package com.backbase.test.mehdijavan.openbank;

import java.util.Date;

public class OBTag {
	private String id; // id of the tag
	private Date date; // date of posting the tag
	private String value; // the tag
	private OBUser user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public OBUser getUser() {
		return user;
	}

	public void setUser(OBUser user) {
		this.user = user;
	}

}
