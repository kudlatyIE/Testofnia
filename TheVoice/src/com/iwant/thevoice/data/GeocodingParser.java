package com.iwant.thevoice.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.iwant.thevoice.model.Components;
import com.iwant.thevoice.model.GeoAddress;
import com.iwant.thevoice.model.Geometry;
import com.iwant.thevoice.model.Location;
import com.iwant.thevoice.model.ViewPort;

public class GeocodingParser {
	
	public static final String  RESULTS="results", ADDRESS_COMPONENTS="address_components",FORMATED_ADDRESS="formatted_address",
			GEOMETRY="geometry", PLACE_ID="place_id", TYPES="types", VIEWPORT="viewport", NORTH="northeast", SOUTH="southwest",
			LOCATION="location",LOCATION_TYPE="location_type", LAT="lat", LNG="lng",LONG_NAME="long_name", STHORT_NAME="short_name", 
			STATUS="status", STATUS_RESULT="OK",
			TAG = GeocodingParser.class.getSimpleName();
	
	
	public static GeoAddress[] getAddress(String data) throws JSONException{
		
		int size;
		JSONObject jo = new JSONObject(data);
		JSONArray jArr = jo.getJSONArray(RESULTS);
		size = jArr.length();
		GeoAddress[] geoAddress = new GeoAddress[size];
		Components[] comp = null;
		for(int i=0;i<jArr.length();i++){
			JSONObject jResult = jArr.getJSONObject(i);
			JSONArray jArrC = jResult.getJSONArray(ADDRESS_COMPONENTS);
			for(int j=0;j<jArrC.length();j++){
				comp = new Components[jArrC.length()];
				JSONObject jC = jArrC.getJSONObject(j);
				
				String longName, shortName; String[] types;
				longName = jC.getString(LONG_NAME);
				shortName = jC.getString(STHORT_NAME);
				
				JSONArray aTypes = jC.getJSONArray(TYPES);
				types = new String[aTypes.length()];
				for(int k=0;k<aTypes.length();k++){
					types[k] = aTypes.getString(k);
				}
				comp[j] = new Components(longName, shortName, types);
				
			}
			String formatedAddress = jResult.getString(FORMATED_ADDRESS);
			
			Location loc, north, south;
			double lng, lat;
			JSONObject jGeo = jResult.getJSONObject(GEOMETRY);
			 lng = jGeo.getJSONObject(LOCATION).getDouble(LNG);
			 lat = jGeo.getJSONObject(LOCATION).getDouble(LAT);
			 loc = new Location(lng, lat);
			 
			 String locationType = jGeo.getString(LOCATION_TYPE);
			 lng = jGeo.getJSONObject(VIEWPORT).getJSONObject(SOUTH).getDouble(LNG);
			 lat = jGeo.getJSONObject(VIEWPORT).getJSONObject(SOUTH).getDouble(LAT);
			 south = new Location(lng, lat); 
			 
			 lng = jGeo.getJSONObject(VIEWPORT).getJSONObject(NORTH).getDouble(LNG);
			 lat = jGeo.getJSONObject(VIEWPORT).getJSONObject(NORTH).getDouble(LAT);
			 north = new Location(lng, lat); 
			 
			 ViewPort port = new ViewPort(north, south);
			 Geometry geo = new Geometry(loc, locationType, port);
			 
			 String placeId = jResult.getString(PLACE_ID);
			 
			 String[] types;
			 JSONArray aType = jResult.getJSONArray(TYPES);
			 types = new String[aType.length()];
			 for(int j=0;j<aType.length();j++){
				 types[j] = aType.getString(j);
			 }
			 
			 String result = jResult.getString(STATUS);
			 if (STATUS_RESULT.equals(result)){
				 Log.d(TAG, "result status: "+result);
				 //Something if OK and else...
			 }
			 Log.d(TAG, "result status: "+result);
			 
			 geoAddress[i] = new GeoAddress(formatedAddress, comp, geo, placeId, types);
			 
		}
		
		
		return geoAddress;
		
	}

}
