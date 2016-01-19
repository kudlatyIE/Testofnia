package com.iwant.thevoice.model;

public class Coordinates {
	
	private double latitude, longitude;
	
	public Coordinates(double lat, double lon){
		this.latitude=lat;
		this.longitude=lon;
	}

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
	

}
