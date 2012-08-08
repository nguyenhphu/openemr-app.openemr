package com.openemr;



import java.util.StringTokenizer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.openemr.Debug;
//import android.os.Debug;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
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
	
	//TestCommit
	
    
	/** Called when the activity is first created. */
	int[] buttonID = new int[15];
	Button[] button = new Button[15];
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
        //set defaults from xml only if this is the first time this method has been called
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);//<---thats this false flag
        
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        
        setContentView(R.layout.main);
        
        //draw sliding drawer
        slidingDrawer = (SlidingDrawer) findViewById(R.id.Drawer);
    	
        CookieSyncManager.createInstance(this);
        webview = (WebView) findViewById(R.id.webview0);
    	
        webview.setWebChromeClient(new wcclient());
	    webview.setWebViewClient(new wvclient(){
	    	//allow ssl certificates for connecting over https
	    	//will maybe have to handle and store encrypted certificates ourselves
	    	public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){ 
	    		handler.proceed(); 
	    		} 
	    	});
	    webview.getSettings().setJavaScriptEnabled(true);
        
	    /*
        webview.setDownloadListener(new DownloadListener() 
    	{

		
    		@Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,long contentLength) 
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType(MIME_TYPE_PDF);
                intent.setData(Uri.parse(url));
                if (canDisplayPdf(activity) == true){
                startActivity(intent);
                }
                else{Popup("you need a pdf viewer");}

            }
        });
       */
    	webview.setHapticFeedbackEnabled(true);

        //set up array for urls and get all buttontexts
       
        
        //create onclick listeners for navigation grid
       
        
        buttonID[0] = R.id.button0;
        buttonID[1] = R.id.button1;
        buttonID[2] = R.id.button2;
        buttonID[3] = R.id.button3;
        buttonID[4] = R.id.button4;
        buttonID[5] = R.id.button5;
        buttonID[6] = R.id.button6;
        buttonID[7] = R.id.button7;
        buttonID[8] = R.id.button8;
        buttonID[9] = R.id.button9;
        buttonID[10] = R.id.button10;
        buttonID[11] = R.id.button11;
        buttonID[12] = R.id.button12;
        buttonID[13] = R.id.button13;
        buttonID[14] = R.id.button14;
        
        SetButtonTexts();
        //initialize onclick listeners for all 15 buttons
        for(int iteration = 0;iteration<15;iteration++)
        {
        	button[iteration] = (Button) findViewById(buttonID[iteration]);
	        button[iteration].setOnClickListener(new MyListener(iteration));
	    }
        
       
	        
        //Load user's selection of start page, or default
        int startpref = Integer.parseInt(preferences.getString("startingpage", "1"));
        if(startpref == 1){load("startpage");}
        else if(startpref == 2){load(getString(R.string.OpenemrLogin));}
        else if(startpref == 3){load(getString(R.string.OpenemrMainPage));}
        else if(startpref == 4){load(getString(R.string.OpenemrMessages));}
        else {load("startpage");}
    	// Initial page load on app start

        
	}
    
    
    
   
    //class for setting onclick listeners
    private class MyListener implements SlidingDrawer.OnClickListener {
        int pos;
        public MyListener (int position) {
            pos = position;
        }
        @Override
        public void onClick(View v) {
        	ButtonClicked(pos);
        }
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
        CookieSyncManager.getInstance().startSync();
        
    }

	@Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        CookieSyncManager.getInstance().stopSync();
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
    
    //the manifest has a line to specify which configuration changes will ignore their default behavior.
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
        //do-nothing
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
    	final int currentpref = Integer.parseInt(preferences.getString("button" + selection + "pref", Integer.toString(selection)));	
    	return currentpref;
    }
  

    public void SetButtonTexts() {
    	
    	//might be able to loop this out to clean it up
        String[] buttontitle = getResources().getStringArray(R.array.buttonchoices);
        
        Button[] temporarybtn = new Button[15];
        for(int iteration = 0; iteration <15; iteration++)
        {
        	temporarybtn[iteration] = (Button) findViewById(buttonID[iteration]);
        	temporarybtn[iteration].setText(buttontitle[Populate(iteration)]);
        }
        
    }
    
    public void load(String path)
    {
    	//moved webview innit and settings to oncreate I think they were only sitting down here while I was
    	//playing with this method
    	String host = Host();
    	//webview.setHttpAuthUsernamePassword(host, "", preferences.getString("user", "username"), preferences.getString("pass", "password"));
    	//webview.getSettings().setSavePassword(true);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setBuiltInZoomControls(true);
	    //also place holder   
	    //webview.setHttpAuthUsernamePassword (preferences.getString("IP", getString(R.string.srv))+MainFolder()+"", null, preferences.getString("user", "username"), preferences.getString("pass", "password"));
		BakeCookie();//setting cookie anywhere but here produces timing issues
		if(path == "startpage")
		{
			webview.loadUrl("file:///android_asset/Firstload.html");
		}else{
			String fulladdress = host+MainFolder()+path+"?site="+preferences.getString("Site", "default");
			Popup("Trying to load "+fulladdress);
		  	Popup("Host = "+host);
	    	Popup("Path = "+path);
	    	Popup("MainFolder = "+MainFolder());
		webview.loadUrl(fulladdress);
		}
    	
    }
    
    String Host()
    {

	    String host;
	    
	    if(preferences.getBoolean("CustomHostString",false) == false )
	    {
		    Boolean portpref = preferences.getBoolean("PortPref", false);
		    String port = preferences.getString("Portnum", getString(R.string.port));
	    	if(portpref == false)
	    	{
	    	    if (preferences.getBoolean("Security", false)== true)
	    	    {
	    	    	host = "https://"+GetDomain();//get host from prefrences
	    	    }
	    	    else
	    	    {
	    	    	host = "http://"+GetDomain();//get host from prefrences
	    	    }
	    	}
	    	else
	    	{
			    if (preferences.getBoolean("Security", false)== true)
			    {
			    	host = "https://"+GetDomain()+":"+port;//get host from prefrences
			    }
			    else
			    {
			    	host = "http://"+GetDomain()+":"+port;//get host from prefrences
			    }
		    }
	    	Popup("domain set as "+GetDomain());
	    }
	    else
	    {
	    	host = preferences.getString("CustomAddress", "http://whatismyip.com");
	    
	 
	    }
	    char check = host.charAt(host.length()-1);//continue on succesfully whether 
    	Character tail = new Character ('/');//user inputs url with trailing slash or not
    	if (check == tail){
    		//do nothing
    		
    	}
    	else{
    		host = host+"/";
    	}
    	Popup("Host = "+host);
    	return host;
    }

    public class wcclient extends WebChromeClient {
    	
    	//browswer UI components
    	
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
        
        
        @Override
        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        	Log.d(this.getClass().getName(), "onReceivedHttpAuthRequest:" + host);
            handler.proceed(preferences.getString("user", "admin"), preferences.getString("pass", "pass"));
            }
        
    
        
        
    }
        
    
    
    
   
    
 
    
    private void PersistentConfig(String currenturl)//this can likely be done in a simpler manner going to map it out
    {
    	//Log.i( "PageStarted", currenturl );
    	String success_url = Host() + MainFolder()+"/interface/main/main_screen.php?auth=login&site=" + preferences.getString("Site", "default");
    	String failure_url = Host() + MainFolder()+"/interface/login/login_frame.php?site=" + preferences.getString("Site", "default");
    	
    	int fail = currenturl.compareTo(failure_url);
    	int success = currenturl.compareTo(success_url);
    	//Popup("success" + success_url);
    	//Popup("fail" + failure_url);
    	//preferences = PreferenceManager.getDefaultSharedPreferences(this);
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

    
 
    private String MainFolder() 
    {
    	String folder;
    	if(preferences.getBoolean("CustomFolderString", false)== true)
    	{
    		folder = preferences.getString("CustomFolder", "openemr");
    	}
    	else
    	{
    		folder = "openemr";
    	}
    	Popup("folder is set to "+folder);
    	return folder+"/";
	}
	//grab whole cookie string
    private String GetCurrentCookie() {
    	String cookie;
    	Boolean portpref = preferences.getBoolean("PortPref", false);
    	String port = preferences.getString("Portnum", getString(R.string.port));
    	if(portpref == false)
    	{
    		if (preferences.getBoolean("Security", false)== true)
    		{
    			cookie = Cm.getCookie("https://" + GetDomain() + MainFolder()+"/interface/main/main_screen.php?auth=login&site=" + preferences.getString("Site", "default"));
    		}else 
    		{
    			cookie = Cm.getCookie("http://" + GetDomain() + MainFolder()+"/interface/main/main_screen.php?auth=login&site=" + preferences.getString("Site", "default"));
    		}
    	}
    	else
    	{	
    		if(preferences.getBoolean("Security", false)== true)
    		{
    			cookie = Cm.getCookie("https://" + GetDomain() + ":" + port + MainFolder()+"/interface/main/main_screen.php?auth=login&site=" + preferences.getString("Site", "default"));
    		}else 
    		{
    			cookie = Cm.getCookie("http://" + GetDomain() + ":" + port + MainFolder()+"/interface/main/main_screen.php?auth=login&site=" + preferences.getString("Site", "default"));
    		}
    	}
		Popup("grabbed current cookie " + cookie);
    	return cookie;
	}
    
    private String PrefsCookieString() 
		{
    	
    	return preferences.getString("the_cookie", "");
		}
    
    
    
	private void BakeCookie()
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
    
	private void Popup(String say_me)//hook for easy debug dialogs
	{
	boolean debugpopup = preferences.getBoolean("Debugging", false);
	if (debugpopup == true) {
		Toast.makeText(this, say_me, Toast.LENGTH_LONG).show();
		}
	
	boolean debuglogcat = preferences.getBoolean("Debugging2", false);
    if(debuglogcat == true)
    {
		Debug.d(say_me);
		}
	
	
	}
      
    
    
  
    
    
    
    private void ButtonClicked(int number)
    	{
    	final String[] buttonurl = getResources().getStringArray(R.array.buttonurls);	
    	
    	int choice = Populate(number);
    	
    	//63 64 or 65 go to customs 1 2 and 3
    	if (choice == 63){webview.loadUrl(preferences.getString("customurl1", getString(R.string.custom1))); slidingDrawer.animateToggle();  return;}
    	if (choice == 64){webview.loadUrl(preferences.getString("customurl2", getString(R.string.custom2))); slidingDrawer.animateToggle();  return;}
    	if (choice == 65){webview.loadUrl(preferences.getString("customurl3", getString(R.string.custom3))); slidingDrawer.animateToggle();  return;}
    	//if (choice == 14){webview.loadUrl("file:///android_asset/Firstload.html"); slidingDrawer.animateToggle();return;}
    	
    	
    	load(buttonurl[choice]);
    	slidingDrawer.animateToggle(); 
    	}
    
    
    private String GetCurrentURL()
    	{
    	WebView currentwebview = (WebView) findViewById(R.id.webview0);
    	String currenturl = currentwebview.getUrl();
    	//Popup(currenturl);
    	return currenturl;
    	}
    
    private String CookieCutterValue(String mycookie)//not used
    	{
    	//String mycookie = PrefsCookieString();  
    	String cookieparts[] = mycookie.split("="); 
    	return cookieparts[1];
    	}
    
    private String CookieCutterName(String mycookie)//not used
	{
    	//String mycookie = PrefsCookieString();  
    	String cookieparts[] = mycookie.split("="); 
    	return cookieparts[0];
	}
    
    private String GetDomain()//grab domain only 
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



    
    public static final String MIME_TYPE_PDF = "application/pdf";

    /**
     * Check if the supplied context can render PDF files via some installed application that reacts to a intent
     * with the pdf mime type and viewing action.
     *
     * @param context
     * @return
     */
    public static boolean canDisplayPdf(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType(MIME_TYPE_PDF);
        if (packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0) {
            return true;
        } else {
            return false;
        }
    }




}
	
//preferences.getString("button" + selection + "pref", Integer.toString(selection)));

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





