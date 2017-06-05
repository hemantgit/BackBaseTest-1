package com.backbase.test.mehdijavan.openbank;

public class OBAccountMetadata {
	private String public_alias; //the public alias of the other account holder
	private String private_alias; //the private alias of the other account holder
	private String more_info; //short text explaining who the other party of the transaction is
	private String URL; //a URL related to the other party e.g. the website of the company
	private String image_URL; //an image URL related to the other party e.g. company logo
	private String open_corporates_URL; //the company corporate URL in the http://opencorporates.com/ web service
	private OBLocation corporate_location;
	private OBLocation physical_location;

	public String getPublic_alias() {
		return public_alias;
	}

	public void setPublic_alias(String public_alias) {
		this.public_alias = public_alias;
	}

	public String getPrivate_alias() {
		return private_alias;
	}

	public void setPrivate_alias(String private_alias) {
		this.private_alias = private_alias;
	}

	public String getMore_info() {
		return more_info;
	}

	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getImage_URL() {
		return image_URL;
	}

	public void setImage_URL(String image_URL) {
		this.image_URL = image_URL;
	}

	public String getOpen_corporates_URL() {
		return open_corporates_URL;
	}

	public void setOpen_corporates_URL(String open_corporates_URL) {
		this.open_corporates_URL = open_corporates_URL;
	}

	public OBLocation getCorporate_location() {
		return corporate_location;
	}

	public void setCorporate_location(OBLocation corporate_location) {
		this.corporate_location = corporate_location;
	}

	public OBLocation getPhysical_location() {
		return physical_location;
	}

	public void setPhysical_location(OBLocation physical_location) {
		this.physical_location = physical_location;
	}
}
