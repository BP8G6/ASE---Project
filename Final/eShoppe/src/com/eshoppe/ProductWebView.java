package com.eshoppe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ProductWebView extends Activity {

	static final String TAG = "ProductWebView";
	private String itemActualUrl = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();

		setContentView(R.layout.activity_webview);
	
		String itemUrl = getIntent().getStringExtra("url");
		System.out.println("++++++ Loading url: " + itemUrl);
		
		WebView browser = (WebView) findViewById(R.id.webview);
		browser.setWebViewClient(new MyBrowser());
		browser.getSettings().setLoadsImagesAutomatically(true);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		browser.loadUrl(itemUrl);
	}
	
	private class MyBrowser extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			Log.d(TAG, "shouldOverrideUrlLoading: " + url);
//			if(!itemActualUrl.isEmpty() && !url.equalsIgnoreCase(itemActualUrl))
//			{
//				Log.d(TAG, "+++++ This is required url, don't do anything");
//				return false;
//			}
//			
//			Log.d(TAG, "+++++ This is not required url, doing something");
			itemActualUrl = url;
			view.loadUrl(itemActualUrl);
			return true;
		}
	}
}
