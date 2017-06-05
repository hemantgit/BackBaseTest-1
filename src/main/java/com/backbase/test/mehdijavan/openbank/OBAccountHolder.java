package com.backbase.test.mehdijavan.openbank;

public class OBAccountHolder {
	private String name;
	private boolean is_alias;
		
	public OBAccountHolder() {
		super();
	}

	public OBAccountHolder(String name, boolean is_alias) {
		super();
		this.name = name;
		this.is_alias = is_alias;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isIs_alias() {
		return is_alias;
	}
	
	public void setIs_alias(boolean is_alias) {
		this.is_alias = is_alias;
	}
}
