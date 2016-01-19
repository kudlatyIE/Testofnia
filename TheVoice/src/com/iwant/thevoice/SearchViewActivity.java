package com.iwant.thevoice;

import java.io.IOException;

import com.iwant.thevoice.model.Coordinates;
import com.iwant.thevoice.model.WantException;
import com.iwant.thevoice.utils.DataSingleton;
import com.iwant.thevoice.utils.VoiceLocation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class SearchViewActivity extends Activity {
	
	private TextView tvPhrase;
	private WebView searchView;
	private final String url = "http://google.ie/#q=";
	private String phrase = "dupa", locationMsg, city="";
	private Activity ac;
	private Coordinates location;
	private final static String TAG = SearchViewActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_search_view);
		ac = this;
		
		searchView = (WebView) findViewById(R.id.searchview_webview_result);
		tvPhrase = (TextView) findViewById(R.id.searchview_text_phrase);
		try {
			location = DataSingleton.getCurrentLocation();
			locationMsg = "Lat: "+location.getLatitude()+" Long: "+location.getLongitude();
			Log.d(TAG, locationMsg);
			
		} catch (WantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			locationMsg = e.getWantExceptionMessage();
		}
		
		Bundle extras = getIntent().getExtras();
		if(extras!=null) phrase = extras.getString(DataSingleton.TAG_PHRASE);
		Log.d(TAG, phrase);
		try {
			city = VoiceLocation.getCity(this, location.getLatitude(), location.getLongitude());
			Log.d(TAG, "city: "+city);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchView.getSettings().setJavaScriptEnabled(true);
	//TODO: try it late
		
		searchView.setWebChromeClient(new WebChromeClient(){
			public void onProgressChanged(WebView view, int progress){
				ac.setProgress(progress*1000);
			}
		});
		searchView.setWebViewClient(new WebViewClient(){
			public void onReceivedError(WebView view, int errCode, String errMsg, String errUrl){
				Toast.makeText(getApplicationContext(), "nosz... "+errMsg+"\n"+errUrl, Toast.LENGTH_LONG).show();
			}
		});
		
		tvPhrase.setText(phrase+" at: \n"+locationMsg+"\n"+city);
		String summary = "<html><body>"+locationMsg+"</body></html>";
//		searchView.loadDataWithBaseURL(url+phrase, summary, "text/html", "UTF-8", null);
		searchView.loadUrl(url+phrase+" "+city);
	}
}
