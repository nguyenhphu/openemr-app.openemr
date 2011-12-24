package com.openemr;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.SlidingDrawer;
//import android.webkit.CookieManager;;




public class Openemrload extends Activity {
    /** Called when the activity is first created. */

	
	WebView webview;
	SharedPreferences preferences;
	SlidingDrawer slidingDrawer;
	final Activity activity = this; //assignment declarations to avoid bothering with using full class names
	//final Resources res = Resources.getSystem();
	
	
    @Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) //all innitations happen here in onCreate
	{
        super.onCreate(savedInstanceState);
        
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);
        slidingDrawer = (SlidingDrawer) findViewById(R.id.Drawer);
        
        //arrays.xml data
        final String[] buttontitle = getResources().getStringArray(R.array.buttonchoices);
        final String[] buttonurl = getResources().getStringArray(R.array.buttonurls);
        
        //get prefrences for button functions
        final String selection1 = preferences.getString("button1pref", getString(R.string.button1txt));//get value from prefs
        final String selection2 = preferences.getString("button2pref", getString(R.string.button2txt));
        final String selection3 = preferences.getString("button3pref", getString(R.string.button3txt));
        final String selection4 = preferences.getString("button4pref", getString(R.string.button4txt));
        final String selection5 = preferences.getString("button5pref", getString(R.string.button5txt));
        final String selection6 = preferences.getString("button6pref", getString(R.string.button6txt));
        final String selection7 = preferences.getString("button7pref", getString(R.string.button7txt));
        final String selection8 = preferences.getString("button8pref", getString(R.string.button8txt));
        final String selection9 = preferences.getString("button9pref", getString(R.string.button9txt));
        final String selection10 = preferences.getString("button10pref", getString(R.string.button10txt));
        final String selection11 = preferences.getString("button11pref", getString(R.string.button11txt));
        final String selection12 = preferences.getString("button12pref", getString(R.string.button12txt));
        final String selection13 = preferences.getString("button13pref", getString(R.string.button13txt));
        final String selection14 = preferences.getString("button14pref", getString(R.string.button14txt));
        final String selection15 = preferences.getString("button15pref", getString(R.string.button15txt));

        
        
        //on click litseners for navigation grid
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(buttontitle[Integer.parseInt(selection1)]);	
        button1.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection1)]);
            	slidingDrawer.animateToggle();
            }
        });




        //on click litseners for navigation grid
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(buttontitle[Integer.parseInt(selection2)]);	
        button2.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection2)]);
            	slidingDrawer.animateToggle();
            }
        });




        //on click litseners for navigation grid
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setText(buttontitle[Integer.parseInt(selection3)]);	
        button3.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection3)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setText(buttontitle[Integer.parseInt(selection4)]);	
        button4.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection4)]);
            	slidingDrawer.animateToggle();
            }
        });





        //on click litseners for navigation grid
        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setText(buttontitle[Integer.parseInt(selection5)]);	
        button5.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection5)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setText(buttontitle[Integer.parseInt(selection6)]);	
        button6.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection6)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setText(buttontitle[Integer.parseInt(selection7)]);	
        button7.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection7)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setText(buttontitle[Integer.parseInt(selection8)]);	
        button8.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection8)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setText(buttontitle[Integer.parseInt(selection9)]);	
        button9.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection9)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setText(buttontitle[Integer.parseInt(selection10)]);	
        button10.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection10)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setText(buttontitle[Integer.parseInt(selection11)]);	
        button11.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection11)]);
            	slidingDrawer.animateToggle();
            }
        });






        //on click litseners for navigation grid
        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setText(buttontitle[Integer.parseInt(selection12)]);	
        button12.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection12)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setText(buttontitle[Integer.parseInt(selection13)]);	
        button13.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection13)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setText(buttontitle[Integer.parseInt(selection14)]);	
        button14.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection14)]);
            	slidingDrawer.animateToggle();
            }
        });







        //on click litseners for navigation grid
        final Button button15 = (Button) findViewById(R.id.button15);
        button15.setText(buttontitle[Integer.parseInt(selection15)]);	
        button15.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	load(buttonurl[Integer.parseInt(selection15)]);
            	slidingDrawer.animateToggle();
            }
        });











        
        
	}
	//hooks for Activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        load(getString(R.string.OpenemrLogin));
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        //onprefrencechanged 
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        
        // The activity is about to be destroyed.
    }
    
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
	            	
	                activity.finish();    
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
        	Intent i = new Intent(this, Preferences.class);
        	startActivity(i);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    
    public void load(String path)
    {
    	webview = (WebView) findViewById(R.id.webview0);
        webview.setWebChromeClient(new wcclient());
	    webview.setWebViewClient(new wvclient());
	    webview.getSettings().setJavaScriptEnabled(true);
    	String host = preferences.getString("IP", getString(R.string.srv));//get host from prefrences
    	char check = host.charAt(host.length()-1);//continue on succesfully whether 
    	Character tail = new Character ('/');//user inputs url with trailing slash or not
    	if (check == tail){
    		//do nothing
    		
    	}
    	else{
    		host = host+"/";
    	}
		webview.getSettings().setJavaScriptEnabled(true);
		
		
	    //also place holder   
	    //webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+"/openemr", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	webview.loadUrl(host+path);
    	
    }
    

    public class wcclient extends WebChromeClient {
    	
    	//browswer ui components
    	
    	public void onProgressChanged(WebView view, int progress) //handler for progress dialog
    	{
    		setTitle("Loading...");
    		setProgress(progress * 100);

    		if(progress == 100)
    		setTitle(R.string.app_name);
       }
    }
    
    public class wvclient extends WebViewClient {
    	//http handling
    	@Override//catch urls to stay in the app do not launch browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webview.loadUrl(url);
            return true;
        }
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
        {
            // Handle http errors
        }
    }
    
    
}
	


/** Process the click to find a patient by name, id, ssn or dob.
function findPatient(findby) {
 var f = document.forms[0];
 if (! f.cb_top.checked) {
  f.cb_top.checked = true;
  toggleFrame(1);
 }
 f.findBy.value = findby;
 setRadio('rb_top', 'dem');
 top.restoreSession();
 document.find_patient.submit();
}
*/








//Find Patient
//javascript:top.restoreSession();document.find_patient.action='/openemr/interface/main/finder/patient_finder.php';document.find_patient.submit();





