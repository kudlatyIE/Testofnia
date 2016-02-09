package com.iwant.thevoice.model;

public class Geometry {

	private Location location;
	private String locationType;
	private ViewPort port;
	
	public Geometry(Location location, String locationType, ViewPort port) {
		this.location = location;
		this.locationType = locationType;
		this.port=port;
	}

	public Location getLocation() {
		return location;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public ViewPort getPort() {
		return port;
	}

	public void setPort(ViewPort port) {
		this.port = port;
	}
	
	
	
}
