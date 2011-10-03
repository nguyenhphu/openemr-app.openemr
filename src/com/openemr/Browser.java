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
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
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
        this.load(R.id.webview0, "/openemr");
  
        
        
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrLeftNav));
            }
        });
        
        
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrNewPatient));
            }
        });
 
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrHtmNavigation));
            }
        });
        
        
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrMessages));
            }
        });
        
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrCalendarOnly));
            }
        });
        
        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrOfficeNotes));
            }
        });
        
        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrAddressBook));
            }
        });
        
        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPatientEncounterForm));
            }
        });
 
        
        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrCreateWorkSchoolNotes));
            }
        });
 
        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrNewDictation));
            }
        });
 
        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrViewDictation));
            }
        });
 
        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrOrderProcedure));
            }
        });
 
        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrViewChangeProcedure));
            }
        });
 
        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReviewBodySystemsROS));
            }
        });
 
        final Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReviewOfBodySystemsChecked));
            }
        });
 
        final Button button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReviewPatientVitalStats));
            }
        });
 
        final Button button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrCreatePatientVitalStatsInstance));
            }
        });
 
        final Button button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrOrdersResults));
            }
        });
 
        final Button button19 = (Button) findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReportsIndex));
            }
        });
 
        final Button button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPendingFollowup));
            }
        });
 
        final Button button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPendingOrders));
            }
        });
 
        
        
        
        
        
        
        
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



