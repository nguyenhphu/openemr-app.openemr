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
//import android.webkit.CookieManager;




public class Openemrload extends Activity {
    /** Called when the activity is first created. */

	
	WebView webview;
	SharedPreferences preferences;
	SlidingDrawer slidingDrawer;
	final Activity activity = this; 
	
	//CookieManager Cm = CookieManager.getInstance(); 
	
    @Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.main);
        slidingDrawer = (SlidingDrawer) findViewById(R.id.Drawer);
      
        
        //set up array for urls and get all buttontexts
        final String[] buttonurl = getResources().getStringArray(R.array.buttonurls);
        SetButtonTexts();
        
        
        //on click litseners for navigation grid
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(1)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(2)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(3)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(4)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(5)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(6)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(7)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(8)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(9)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(10)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(11)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(12)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(13)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(14)]);
            	slidingDrawer.animateToggle();
            }
        });


        final Button button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	load(buttonurl[Populate(15)]);
            	slidingDrawer.animateToggle();
            }
        });







  
        
	}
	//hooks for Activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        load(getString(R.string.OpenemrMainPage));
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        
        SetButtonTexts();
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
        //Cm.removeAllCookie();

        
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
    public int Populate(int selection){
    	final int currentselection = Integer.parseInt(preferences.getString("button" + selection + "pref", Integer.toString(selection)));	
    	return currentselection;
    }
  

    public void SetButtonTexts() {
        String[] buttontitle = getResources().getStringArray(R.array.buttonchoices);
        
        Button temporarybtn1 = (Button) findViewById(R.id.button1);
    	temporarybtn1.setText(buttontitle[Populate(1)]);
        
    	Button temporarybtn2 = (Button) findViewById(R.id.button2);
    	temporarybtn2.setText(buttontitle[Populate(2)]);
        
    	Button temporarybtn3 = (Button) findViewById(R.id.button3);
    	temporarybtn3.setText(buttontitle[Populate(3)]);
        
    	Button temporarybtn4 = (Button) findViewById(R.id.button4);
    	temporarybtn4.setText(buttontitle[Populate(4)]);
        
    	Button temporarybtn5 = (Button) findViewById(R.id.button5);
    	temporarybtn5.setText(buttontitle[Populate(5)]);
        
    	Button temporarybtn6 = (Button) findViewById(R.id.button6);
    	temporarybtn6.setText(buttontitle[Populate(6)]);

    	Button temporarybtn7 = (Button) findViewById(R.id.button7);
    	temporarybtn7.setText(buttontitle[Populate(7)]);
    	

        Button temporarybtn8 = (Button) findViewById(R.id.button8);
    	temporarybtn8.setText(buttontitle[Populate(8)]);

        Button temporarybtn9 = (Button) findViewById(R.id.button9);
    	temporarybtn9.setText(buttontitle[Populate(9)]);

        Button temporarybtn10 = (Button) findViewById(R.id.button10);
    	temporarybtn10.setText(buttontitle[Populate(10)]);

        Button temporarybtn11 = (Button) findViewById(R.id.button11);
    	temporarybtn11.setText(buttontitle[Populate(11)]);

        Button temporarybtn12 = (Button) findViewById(R.id.button12);
    	temporarybtn12.setText(buttontitle[Populate(12)]);

        Button temporarybtn13 = (Button) findViewById(R.id.button13);
    	temporarybtn13.setText(buttontitle[Populate(13)]);

        Button temporarybtn14 = (Button) findViewById(R.id.button14);
    	temporarybtn14.setText(buttontitle[Populate(14)]);

        Button temporarybtn15 = (Button) findViewById(R.id.button15);
    	temporarybtn15.setText(buttontitle[Populate(15)]);
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
		
		webview.loadUrl("javacript:top.restoreSession()");
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





