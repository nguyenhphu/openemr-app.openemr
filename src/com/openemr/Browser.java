package com.openemr;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
//import android.widget.GridView;
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
	SlidingDrawer slidingDrawer;
	//GridView MyGrid;
	     
	
	@Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) //all innitations happen here in onCreate
	{
        super.onCreate(savedInstanceState);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);
        slidingDrawer = (SlidingDrawer) findViewById(R.id.Drawer);
       
        this.load(R.id.webview0, "openemr/");
        

  
        
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.Main));
            	slidingDrawer.animateToggle();
            }
        });
        
        
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrMessages));
            	slidingDrawer.animateToggle();
            }
        });
 
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrCalendarSchedule));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPatientSummary));
            	slidingDrawer.animateToggle();
            }
        });
       
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrEncounters));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener()
        
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrNewEncounter));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrAddressBook));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrSearch));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrAuthorizations));
            	slidingDrawer.animateToggle();
            }
        });
 
        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrLabResultsMessages));
            	slidingDrawer.animateToggle();
            }
        });   
        
        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrOfficeNotes));
            	slidingDrawer.animateToggle();
            }
        });        
        
        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener()
        
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReportsIndex));
            	slidingDrawer.animateToggle();
            }
        });        
        
        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPendingFollowup));
            	slidingDrawer.animateToggle();
            }
        });
        
        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrDrugInventory));
            	slidingDrawer.animateToggle();
            }
        });        
        
        final Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrReviewBodySystemsROS));
            	slidingDrawer.animateToggle();
            }
        });        
        
        
        
       
        
	};

	@Override //handle back button event
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
		if (slidingDrawer.isOpened());{
			slidingDrawer.close();
		}
		
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) 
		{
			
			webview.goBack();
			
			return true;
		}
		if ((keyCode == KeyEvent.KEYCODE_BACK))
		{
			
				
			webview.stopLoading();
			//Ask the user if they want to quit
	        new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle(R.string.quit)
	        .setMessage(R.string.really_quit)
	        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

	            @Override
	            public void onClick(DialogInterface dialog, int which) {

	                //Stop the activity
	            	
	                Browser.this.finish();    
	            }

	        })
	        .setNegativeButton(R.string.no, null)
	        .show();

	        return false;
	    }
	    else {
	        return super.onKeyDown(keyCode, event);
	    }

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
	    //webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+"/openemr", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	webview.loadUrl(host+arg2);

    }
    
    
    
    
}



