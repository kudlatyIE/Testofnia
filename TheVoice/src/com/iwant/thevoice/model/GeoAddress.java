package com.iwant.thevoice.model;

public class GeoAddress {
	
	private String formattedAddress;
	private Components[] components;
	private Geometry geometry;
	private String placeId;
	private String[] types;
	
	
	public GeoAddress(String formattedAddress, Components[] components, Geometry geometry, String placeId, String[] types) {

		this.formattedAddress = formattedAddress;
		this.components = components;
		this.geometry = geometry;
		this.placeId = placeId;
		this.types = types;
	}


	public String getFormattedAddress() {
		return formattedAddress;
	}


	public Components[] getComponents() {
		return components;
	}


	public Geometry getGeometry() {
		return geometry;
	}


	public String getPlaceId() {
		return placeId;
	}


	public String[] getTypes() {
		return types;
	}


	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}


	public void setComponents(Components[] components) {
		this.components = components;
	}


	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}


	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}


	public void setTypes(String[] types) {
		this.types = types;
	}
	
	

}


