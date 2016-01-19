package com.iwant.thevoice;

import com.iwant.thevoice.utils.DataSingleton;
import com.iwant.thevoice.utils.VoiceLocation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btnGoCapture;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//TODO: lets start localization here and set in static  singleton
		DataSingleton.setCurrentLocation(VoiceLocation.getLocation(this));
		
		btnGoCapture = (Button) findViewById(R.id.main_btn_gocapture);
		
		intent = new Intent(getApplicationContext(), CaptureActivity.class);
		btnGoCapture.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent);
			}
			
		});
	}
}
