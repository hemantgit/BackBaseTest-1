package com.backbase.test.mehdijavan.openbank;

import java.util.Date;

public class OBComment {
	private String id; // id of the comment
	private Date date; // date of posting the comment
	private String value; // the comment
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
