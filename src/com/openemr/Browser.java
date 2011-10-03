package com.openemr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/**
 * Reusable class for creating fully funtional webviews.
 * @author arimal
 *
 */



public class Browser extends Activity 
{
	WebView webview;
	SharedPreferences preferences;
	final Activity activity = this; //shorthand assignments
	@Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) //all innitations happen here in onCreate
	{
        super.onCreate(savedInstanceState);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);
        this.load(R.id.MainBrowser, "/openemr");
        this.load(R.id.webview1, "/openemr/interface/main/main_screen.php");
	  //  webview.loadUrl(preferences.getString("IP", getString(R.string.srv))+"/openemr");
	   //	this.load(R.id.webview1, "/openemr");
       //webview.loadUrl(preferences.getString("IP", getString(R.string.srv))+"/openemr");
       
	}   	   	
	@Override //handle back button event
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) 
		{
			webview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	};
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //add menu here
        //do not call super.onCreateOptionsMenu(menu) here
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);//defines menu to build
        return true;
        
    }
 
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //handle on menu item selected here
        //do not call super.onMenuItemSelected(featureId, item) here
    	switch (item.getItemId()) {
        case R.id.settings:
        	Intent i = new Intent(Browser.this, Preferences.class);
        	startActivity(i);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    public void load(int arg1, String arg2)
    {
    	String host = preferences.getString("IP", getString(R.string.srv));
    	webview = (WebView) findViewById(arg1);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebChromeClient(new WebChromeClient() 
		{
			public void onProgressChanged(WebView view, int progress) //handler for progress dialog
			{
				activity.setTitle("Loading...");
				activity.setProgress(progress * 100);

				if(progress == 100)
				activity.setTitle(R.string.app_name);
           }
		});
	       webview.setWebViewClient(new WebViewClient() 
	       {
	    	   //@Override
	           //public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) 
	           //{
	        	//   handler.proceed("me@test.com", "mypassword");
	         //  }
	           @Override
	           public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
	           {
	               // Handle http errors
	           }


	           @Override
	           public boolean shouldOverrideUrlLoading(WebView view, String url) //ensures our application handles urls instead of the browser application
	           {
               view.loadUrl(url);
               return true;
	           }
	           
	    });
	    webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+"/openemr", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	webview.loadUrl(host+arg2);

    }
    
    
}



