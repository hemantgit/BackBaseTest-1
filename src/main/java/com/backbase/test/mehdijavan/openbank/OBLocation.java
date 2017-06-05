package com.backbase.test.mehdijavan.openbank;

import java.util.Date;

public class OBLocation {
	private double latitude;
	private double longitude;
	private Date date; // date of posting the geo tag
	private OBUser user;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OBUser getUser() {
		return user;
	}

	public void setUser(OBUser user) {
		this.user = user;
	}
}
