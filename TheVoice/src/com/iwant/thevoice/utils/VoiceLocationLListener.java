package com.iwant.thevoice.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class VoiceLocationLListener  implements LocationListener{
	
	public static double sensiLongitude, sensiLatitude;

	@Override
	public void onLocationChanged(Location location) {
		location.getLatitude();
		location.getLongitude();
		
		sensiLongitude = location.getLatitude();
		sensiLongitude = location.getLongitude();
		
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
}
