package com.iwant.thevoice.model;

public class ViewPort {
	
	Location northEast, southwest;

	public ViewPort(Location northEast, Location southwest) {
		this.northEast = northEast;
		this.southwest = southwest;
	}

	public Location getNorthEast() {
		return northEast;
	}

	public Location getSouthwest() {
		return southwest;
	}

	public void setNorthEast(Location northEast) {
		this.northEast = northEast;
	}
	public void setNorthEast(double lng, double lat) {
		this.northEast = new Location(lng,lat);
	}
	
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	public void setSouthwest(double lng, double lat) {
		this.southwest = new Location(lng,lat);
	}
	

}
