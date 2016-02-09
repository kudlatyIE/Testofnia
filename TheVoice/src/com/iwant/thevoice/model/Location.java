package com.iwant.thevoice.model;

public class Location {

	double lng, lat;
	
	public Location(double lng, double lat) {
		this.lng = lng;
		this.lat = lat;
	}

	public double getLon() {
		return lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLon(double lon) {
		this.lng = lon;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}


