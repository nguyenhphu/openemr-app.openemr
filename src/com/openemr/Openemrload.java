package com.openemr;

//push from eclipse
import android.app.Activity;
import android.app.ActivityGroup;
//import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
//must convert to use fragments
public class Openemrload extends ActivityGroup
{
	main main;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, main.class);
        startActivity(intent);
       
 
       
    }
 //menus are handled in the parent while created in the child
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return getLocalActivityManager().getCurrentActivity().onCreateOptionsMenu(menu);
    }
 
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return getLocalActivityManager().getCurrentActivity().onMenuItemSelected(featureId, item);
    }
	
    
    //first child activity for running webviews
    public class main extends Activity
	{
		final Activity activity = this; //assignment declarations to avoid bothering with using full class names
		
		
		WebView webview;
		@Override //override annotations allow us to create our own functionality for the any methods of the super class
		public void onCreate(Bundle savedInstanceState)//all innitations happen here in onCreate
		{
			super.onCreate(savedInstanceState);
			this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
			setContentView(R.layout.main);
			webview = (WebView) findViewById(R.id.webview);
			webview.getSettings().setJavaScriptEnabled(true);
        
			//webviewclient and webchromeclient will need to have there own classes soon currently creating them anew at runtime
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
        
        	
        	webview.loadUrl(getString(R.string.srv)+"/openemr");
        	   	
		}

		@Override //handle back button event
		public boolean onKeyDown(int keyCode, KeyEvent event) 
		{ /**method to handle key presses*/
			if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) 
			{
				webview.goBack();
				return true;
			}
			return super.onKeyDown(keyCode, event);
		}
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
	        	
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	     
	}
}
   

   



