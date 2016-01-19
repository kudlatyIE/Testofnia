package com.iwant.thevoice.utils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.iwant.thevoice.model.Coordinates;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

public class VoiceLocation {
	
	private final static String TAG = VoiceLocation.class.getSimpleName();
	
	public static Coordinates getLocation(Activity ac){
		
		Location location = null;
		LocationManager lm=null;
		LocationListener listener = new VoiceLocationLListener();
		
		lm = (LocationManager) ac.getSystemService(Context.LOCATION_SERVICE);
		if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
			location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		}else{
			if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
				location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			}else return null;
		}
		Criteria c = new Criteria();
		c.setAccuracy(Criteria.ACCURACY_FINE);
		c.setCostAllowed(false);
		String provider = lm.getBestProvider(c, true);
		
		lm.getProviders(true);
		if(location!=null){
			Log.d(TAG, "latitude: "+location.getLatitude()+" longitude: "+location.getLongitude());
			return new Coordinates(location.getLatitude(),location.getLongitude());
		}
		return null;
	}
	
	public static String getCity(Activity ac, double latitude, double longitude) throws IOException{
		
		Geocoder gc = new Geocoder(ac, Locale.getDefault());
		List<Address> list = gc.getFromLocation(latitude, longitude, 1);
		String city;// = list.get(0).getLocality();
		Log.i(TAG, "1 address line: "+list.get(0).getAddressLine(0));
		Log.i(TAG, "admin area: "+list.get(0).getAdminArea()); // return city for Dublin
		Log.i(TAG, "country: "+list.get(0).getCountryName());
		Log.i(TAG, "locality: "+list.get(0).getLocality()); // return street area for Ringsend
		Log.i(TAG, "sub admin: "+list.get(0).getSubAdminArea());
		Log.i(TAG, "sub local: "+list.get(0).getSubLocality());
		Log.i(TAG, "postal code: "+list.get(0).getPostalCode());
//		if(city==null) 
			city = list.get(0).getAdminArea() + " "+list.get(0).getLocality();
		return city;
	}

}
