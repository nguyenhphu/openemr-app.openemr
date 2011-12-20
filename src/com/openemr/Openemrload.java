package com.openemr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Openemrload extends Activity {
    /** Called when the activity is first created. */

	Browser browser;
	
	
	final Activity activity = this; //assignment declarations to avoid bothering with using full class names

	
	
    @Override//override annotations allow us to create our own functionality for the any methods of the super class
    public void onCreate(Bundle savedInstanceState) //all innitations happen here in onCreate
	{
        super.onCreate(savedInstanceState);
      
        Intent i = new Intent(Openemrload.this, Browser.class);
    	startActivity(i);
    	
	}
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        super.finish();
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

    //browser.load(R.id.webview0, "/openemr");
 
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





