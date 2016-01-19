package com.iwant.thevoice;

import java.util.ArrayList;
import java.util.Locale;

import com.iwant.thevoice.utils.DataSingleton;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CaptureActivity extends Activity {
	
	private Button btnCapture;
	private TextView tvResult;
	private final int REQ_CODE = 100;
	private String result = "nothing....";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture);
		
		tvResult = (TextView) findViewById(R.id.capture_text_result);
		btnCapture = (Button) findViewById(R.id.capture_btn_capture);
		tvResult.setText(result);
		
		btnCapture.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				promtSpeechDialog();
			}
			
		});
	}
	
	
	private void promtSpeechDialog(){
		
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.EXTRA_LANGUAGE_MODEL);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Sey something!");
		try{
			startActivityForResult(intent, REQ_CODE);
		}catch(ActivityNotFoundException e){
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "Language not supported", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
	protected void onActivityResult(int codeRequest, int resultCode, Intent data){
		super.onActivityResult(codeRequest, resultCode, data);
		
		switch(codeRequest){
		case REQ_CODE:
			if(resultCode==Activity.RESULT_OK && data!=null){
					ArrayList<String> list = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
					result = list.get(0);
					tvResult.setText(result);
					Intent intent = new Intent(getApplicationContext(),SearchViewActivity.class);
					intent.putExtra(DataSingleton.TAG_PHRASE, result);
					startActivity(intent);
//					Intent intent = new Intent(Intent.ACTION_VIEW);
//					intent.setData(Uri.parse("http://google.ie/#q="+result));
//					if(intent.resolveActivity(getPackageManager())!=null) startActivity(intent);
			}
		}
		
	}
}
