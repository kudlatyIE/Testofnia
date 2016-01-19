package com.iwant.thevoice.utils;

import com.iwant.thevoice.model.Coordinates;
import com.iwant.thevoice.model.ExceptionCode;
import com.iwant.thevoice.model.WantException;

public class DataSingleton {
	
	private static Coordinates currentLocation=null;
	//TODO: put here list of all TAGs...............................
	public static String TAG_PHRASE="phrase";
	

	public static Coordinates getCurrentLocation() throws WantException {
		if(currentLocation == null) throw new WantException(ExceptionCode.EX_LOCALISATION);
		return currentLocation;
	}

	public static void setCurrentLocation(Coordinates currentLocation) {
		DataSingleton.currentLocation = currentLocation;
	}
	
	public static void setCurrentLocation(double latitude, double longitude) {
		DataSingleton.currentLocation = new Coordinates(latitude, longitude);
	}

}
