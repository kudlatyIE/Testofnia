package com.iwant.thevoice.model;

public class Components {
	
	String longName, shortName;
	String[] types;
	
	public Components(String longName, String shortName, String[] types) {
		this.longName = longName;
		this.shortName = shortName;
		this.types = types;
	}

	public String getLongName() {
		return longName;
	}

	public String getShortName() {
		return shortName;
	}

	public String[] getTypes() {
		return types;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

}
