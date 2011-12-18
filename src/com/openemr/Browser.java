package com.openemr;



import android.app.Activity;
import android.content.Context;
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
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
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
	//GridView MyGrid;
	    
	
	@Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) //all innitations happen here in onCreate
	{
        super.onCreate(savedInstanceState);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);
        
        //MyGrid = (GridView)findViewById(R.id.MyGrid);
        //MyGrid.setAdapter(new ButtonAdapter(this));
        //MyGrid.setContentView(R.layout.grid_items); 
        this.load(R.id.webview0, "openemr/");
  
        
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrCalendarSchedule));
            }
        });
        
        
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrMessages));
            }
        });
 
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrPatientSummary));
            }
        });
        
        
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrEncounters));
            }
        });
        
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() 
        {
            public void onClick(View v) 
            {
            	load(R.id.webview0, getString(R.string.OpenemrNewEncounter));
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
            	load(R.id.webview0, getString(R.string.OpenemrSearch));
            }
        });
 
   
        
        
        
        
        
        
        
	  //  webview.loadUrl(preferences.getString("IP", getString(R.string.srv))+"/openemr");
	   //this.load(R.id.webview1, "/openemr");
       //webview.loadUrl(preferences.getString("IP", getString(R.string.srv))+"/openemr");
       
        
	}; 
	
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
	    //webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+"/openemr", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	webview.loadUrl(host+arg2);

    }
    
    
    
    
    
    public class ButtonAdapter extends BaseAdapter
    {
       Context MyContext;
       
       public ButtonAdapter(Context _MyContext)
       {
          MyContext = _MyContext;
       }
       
       @Override
       public int getCount() 
       {
                         /* Set the number of element we want on the grid */
          return 9;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) 
       {
          View MyView = convertView;
          
          if ( convertView == null )
          {
                                 /*we define the view that will display on the grid*/
             
             //Inflate the layout
             LayoutInflater li = (LayoutInflater) MyContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

             
             MyView = li.inflate(R.layout.grid_items, null);
             

             
             
            
          }
          
          return MyView;
       }

       @Override
       public Object getItem(int arg0) {
          // TODO Auto-generated method stub
          return null;
       }

       @Override
       public long getItemId(int arg0) {
          // TODO Auto-generated method stub
          return 0;
       }
    }
}



