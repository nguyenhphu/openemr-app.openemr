package com.openemr;



import java.util.StringTokenizer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.http.SslError;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;





public class Openemrload extends Activity {
	
	
	
    
	/** Called when the activity is first created. */

	
	WebView webview;
	SharedPreferences preferences;
	SlidingDrawer slidingDrawer;
	final Activity activity = this;
	CookieManager Cm = CookieManager.getInstance();
	
	
	//public String sessionCookie;
    @Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        
        //defining preferences
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        
        setContentView(R.layout.main);
        
        //draw sliding drawer
        slidingDrawer = (SlidingDrawer) findViewById(R.id.Drawer);
    	
        CookieSyncManager.createInstance(this);
    	
    	// Initial page load on app start
    	load(getString(R.string.OpenemrMainPage));

        //set up array for urls and get all buttontexts
        SetButtonTexts();
        
        //create onclick listeners for navigation grid
        
        final Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(0);
            }
        });
        
        
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(1);
            }
        });


        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(2);
            }
        });


        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(3);
            }
        });


        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(4);
            }
        });


        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(5);
            }
        });


        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(6);
            }
        });


        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
            	ButtonClicked(7);
            }
        });


        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(8);
            }
        });


        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(9);
            }
        });


        final Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(10);
            }
        });


        final Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(11);
            }
        });


        final Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(12);
            }
        });


        final Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(13);
            }
        });


        final Button button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new SlidingDrawer.OnClickListener()
        {
            public void onClick(View v) 
            {
                	
            	ButtonClicked(14);
            }
        });









  
        
	}
	//hooks for Activity life cycle
    @Override
    protected void onStart() {
        super.onStart();
        
        // The activity is about to become visible.
        Popup("debugging enabled");
    }
    @Override
    protected void onResume() {
        super.onResume();
        //webview.loadUrl("javascript:alert(document.cookie)");
       
        //Popup("cookie stored in prefs is" +  PrefsCookieString());
        SetButtonTexts();
        // The activity has become visible (it is now "resumed").
        //CookieSyncManager.getInstance().startSync();
        
    }

	@Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        //CookieSyncManager.getInstance().stopSync();
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Cm.removeAllCookie();

        
        // The activity is about to be destroyed.
    }
    @Override//close on long press of back button
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
    	if ((keyCode == KeyEvent.KEYCODE_BACK))
		{	//seems to only get called when a short press is followed directly by a long press	
			webview.stopLoading();
			//Ask the user if they want to quit
	        new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle(R.string.quit)
	        .setMessage(R.string.really_quit)
	        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() 
	        {

	            @Override
	            public void onClick(DialogInterface dialog, int which) {
	                //Stop the activity
	            	
	                activity.finish();    
	            }

	        })
	        .setNegativeButton(R.string.no, null).show();

	        return true;
	    }
    	else
    	{
    	return super.onKeyLongPress(keyCode, event);
    	}
    }	
    
    
    
    @Override //handle back button event
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
		if (slidingDrawer.isOpened());
		{
			slidingDrawer.close();
		}
		
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) 
		{
			
			webview.goBack();
			
			return true;
		}
		
	    else 
	    {
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
        
        Button temporarybtn0 = (Button) findViewById(R.id.button0);
    	temporarybtn0.setText(buttontitle[Populate(0)]);
        
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

    }
    
    public void load(String path)
    {
    	
    	webview = (WebView) findViewById(R.id.webview0);
        webview.setWebChromeClient(new wcclient());
	    webview.setWebViewClient(new wvclient(){ 
	    	public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){ 
	    		handler.proceed(); 
	    		} 
	    	});
	    webview.getSettings().setJavaScriptEnabled(true);
	    String host;
	    Boolean portpref = preferences.getBoolean("PortPref", false);
	    String port = preferences.getString("Portnum", getString(R.string.port));
    	if(portpref == false)
    	{
    	    if (preferences.getBoolean("Security", false)== true)
    	    {
    	    	host = "https://" + GetDomain();//get host from prefrences
    	    }
    	    else
    	    {
    	    	host = "http://" + GetDomain();//get host from prefrences
    	    }
    	}
    	else
    	{
		    if (preferences.getBoolean("Security", false)== true)
		    {
		    	host = "https://" + GetDomain()+ ":" + port;//get host from prefrences
		    }
		    else
		    {
		    	host = "http://" + GetDomain()+ ":" + port;//get host from prefrences
		    }
	    }
    	
	    char check = host.charAt(host.length()-1);//continue on succesfully whether 
    	Character tail = new Character ('/');//user inputs url with trailing slash or not
    	if (check == tail){
    		//do nothing
    		
    	}
    	else{
    		host = host+"/";
    	}
    	
    	//webview.setHttpAuthUsernamePassword(host, "", preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	//webview.getSettings().setSavePassword(true);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setBuiltInZoomControls(true);
	    //also place holder   
	    //webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+"/openemr", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
		BakeCookie();//setting cookie anywhere but here produces timing issues
		webview.loadUrl(host+path);
    	
    	
    }
    

    public class wcclient extends WebChromeClient {
    	
    	//browswer ui components
    	
    	public void onProgressChanged(WebView view, int progress) //handler for progress dialog
    	{
    		setTitle("Loading...");
    		setProgress(progress * 100);

    		if(progress == 100){
	    		setTitle(R.string.app_name);
	    		Popup("Current url: " + GetCurrentURL());
	    		PersistentConfig(GetCurrentURL());
	    		}
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
        
        
     /*   @Override
        public void onReceivedHttpAuthRequest(WebView view,
                HttpAuthHandler handler, String host, String realm) {

            handler.proceed(preferences.getString("user", "username"), preferences.getString("pass", "password"));}
        
    */
        
        
        }
        
    
    
    
   
    
 
    
    public void PersistentConfig(String currenturl)//this can likely be done in a simpler manner going to map it out
    {
    	//Log.i( "PageStarted", currenturl );
    	String success_url;
    	String failure_url;
    	Boolean portpref = preferences.getBoolean("PortPref", false);
    	String port = preferences.getString("Portnum", getString(R.string.port));
    	if(portpref == false)
    	{
    		if (preferences.getBoolean("Security", false)== true)
        	{
    	    	success_url = "https://" + GetDomain() + "/openemr/interface/main/main_screen.php?auth=login&site=default";
    	    	failure_url = "https://" + GetDomain() + "/openemr/interface/login/login_frame.php?site=default";
    	    }
        	else
        	{
    	    	success_url = "http://" + GetDomain() + "/openemr/interface/main/main_screen.php?auth=login&site=default";
    	    	failure_url = "http://" + GetDomain() + "/openemr/interface/login/login_frame.php?site=default";
    	    }
    	}
    	else
    	{
    	
	    	if (preferences.getBoolean("Security", false)== true)
	    	{
		    	success_url = "https://" + GetDomain() + ":" + port + "/openemr/interface/main/main_screen.php?auth=login&site=default";
		    	failure_url = "https://" + GetDomain() + ":" + port + "/openemr/interface/login/login_frame.php?site=default";
		    }
	    	else
	    	{
		    	success_url = "http://" + GetDomain() + ":" + port + "/openemr/interface/main/main_screen.php?auth=login&site=default";
		    	failure_url = "http://" + GetDomain() + ":" + port + "/openemr/interface/login/login_frame.php?site=default";
		    }
    	}
    	int fail = currenturl.compareTo(failure_url);
    	
    	int success = currenturl.compareTo(success_url);
    	preferences = PreferenceManager.getDefaultSharedPreferences(this);
    	SharedPreferences.Editor settings_editor = preferences.edit();
    	if(fail == 0)
    	{
    		Popup( "Please Login");
    		//Popup(failure_url);
    		//Popup(currenturl);
    		//Popup(success_url);
    		
    		
    	}
    	if(success == 0)
    	{
    		
    		Popup("Login successful, copying cookie to prefs");
    		String cookie_string = GetCurrentCookie();
    		if(cookie_string.length() > 1)
    		{
    			settings_editor.putBoolean("got_session_cookie",true);
    			settings_editor.putString("the_cookie",cookie_string);
    			settings_editor.commit();
    			Popup(PrefsCookieString() + " copied to prefs successfully");
    		}
    		
    	}
    	if((fail != 0)&&(success != 0))
    	{
    		//super.onPageStarted(view, url);
    		Popup("Current page is not a login page or successful login");
    		//Popup(failure_url);
    		//Popup(currenturl);
    		//Popup(success_url);
    		//BakeCookie();
    	}
    }

    
 
    //grab whole cookie string
    String GetCurrentCookie() {
    	String cookie;
    	Boolean portpref = preferences.getBoolean("PortPref", false);
    	String port = preferences.getString("Portnum", getString(R.string.port));
    	if(portpref == false)
    	{
    		if (preferences.getBoolean("Security", false)== true)
    		{
    			cookie = Cm.getCookie("https://" + GetDomain() + "/openemr/interface/main/main_screen.php?auth=login&site=default");
    		}else 
    		{
    			cookie = Cm.getCookie("http://" + GetDomain() + "/openemr/interface/main/main_screen.php?auth=login&site=default");
    		}
    	}
    	else
    	{	
    		if(preferences.getBoolean("Security", false)== true)
    		{
    			cookie = Cm.getCookie("https://" + GetDomain() + ":" + port + "/openemr/interface/main/main_screen.php?auth=login&site=default");
    		}else 
    		{
    			cookie = Cm.getCookie("http://" + GetDomain() + ":" + port + "/openemr/interface/main/main_screen.php?auth=login&site=default");
    		}
    	}
		Popup("grabbed current cookie " + cookie);
    	return cookie;
	}
    
	public String PrefsCookieString() 
		{
    	
    	return preferences.getString("the_cookie", "");
		}
    
    
    
    void BakeCookie()
    	{
    	
    	String  sessionCookie = PrefsCookieString();
    	//String cookiepiecename = CookieCutterName(sessionCookie);
    	//String cookiepiecevalue = CookieCutterValue(sessionCookie);
    	
    	if (sessionCookie != null) 
    		{
    		//Cm.removeSessionCookie();
    		Cm.setCookie(GetDomain(), sessionCookie);
    		
    		CookieSyncManager.getInstance().sync();
    		Popup("setting cookie from prefs " + sessionCookie);
    		}
    	}
    
    void Popup(String say_me)//hook for easy debug dialogs
    	{
    	boolean debugpopup = preferences.getBoolean("Debugging", false);
    	if (debugpopup == true) {
    	
    	
    	Toast.makeText(this, say_me, Toast.LENGTH_LONG).show();
    	}
    	}
    
      
    
    
  
    
    
    
    void ButtonClicked(int number)
    	{
    	final String[] buttonurl = getResources().getStringArray(R.array.buttonurls);	
    	
    	int choice = Populate(number);
    	
    	//63 64 or 65 go to customs 1 2 and 3
    	if (choice == 63){webview.loadUrl(preferences.getString("customurl1", getString(R.string.custom1))); slidingDrawer.animateToggle();  return;}
    	if (choice == 64){webview.loadUrl(preferences.getString("customurl2", getString(R.string.custom2))); slidingDrawer.animateToggle();  return;}
    	if (choice == 65){webview.loadUrl(preferences.getString("customurl3", getString(R.string.custom3))); slidingDrawer.animateToggle();  return;}
    	
    	
    	
    	load(buttonurl[choice]);
    	slidingDrawer.animateToggle(); 
    	}
    
    
    String GetCurrentURL()
    	{
    	WebView currentwebview = (WebView) findViewById(R.id.webview0);
    	String currenturl = currentwebview.getUrl();
    	//Popup(currenturl);
    	return currenturl;
    	}
    
    String CookieCutterValue(String mycookie)//not used
    	{
    	//String mycookie = PrefsCookieString();  
    	String cookieparts[] = mycookie.split("="); 
    	return cookieparts[1];
    	}
    
    String CookieCutterName(String mycookie)//not used
	{
    	//String mycookie = PrefsCookieString();  
    	String cookieparts[] = mycookie.split("="); 
    	return cookieparts[0];
	}
    
    String GetDomain()//grab domain only 
	{
    	
    	String server = preferences.getString("IP", getString(R.string.srv));	
    	
    
    	StringTokenizer domainpart = new StringTokenizer(server, "//");
	    String firsttoken = domainpart.nextToken();
	    
	    while (domainpart.hasMoreTokens()) {
	    	String secondtoken = domainpart.nextToken();
	    	if (secondtoken != null) {
	    		Popup("The domain is " + secondtoken);
	    		return secondtoken;
	    	}
	    	}
	    Popup("The domain is " + firsttoken);
	    return firsttoken;
	    
	}



    
    



}
	
//Integer.parseInt(preferences.getString("button" + selection + "pref", Integer.toString(selection)));

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


//Toast.makeText(this, PrefsCookieString(), Toast.LENGTH_SHORT).show();





//Find Patient
//javascript:top.restoreSession();document.find_patient.action='/openemr/interface/main/finder/patient_finder.php';document.find_patient.submit();





