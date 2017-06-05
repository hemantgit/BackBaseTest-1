package com.backbase.test.mehdijavan.openbank;

public class OBUser {
	private String provider; // name of party that authorized the user e.g. bank_name/facebook/twitter
	private String id; // ID (given by the user's provider) of the user making the comment
	private String display_name; // display name of user

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
}
