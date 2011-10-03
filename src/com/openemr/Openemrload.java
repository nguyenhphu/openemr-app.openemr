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
    //browser.load(R.id.webview0, "/openemr");
 
}
	
		
        //none of this works yet figuring out 3rd party api
        // handle
/**
        Button handle = new Button( this );
        handle.setText("Push Me");

        // content
       
        TextView content = new TextView(this);
        content.setText("Sample Text.");


// left navigation frame 
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/left_nav.php");

// Calendar/schedule
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/main.php");

//navigation (not with buttons)
//webview.loadUrl(getString(R.string.srv)+"/openemr/main/main_navigation.php");

// new patient dialog
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/new/new_patient.php");

//messages
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/messages/messages.php");

// lab results
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/messages/lab_results_messages.php");

// authorizations
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/authorizations/authorizations.php");

// authorizations (full)
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/authorizations/authorizations_full.php");

// just calendar
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/calendar/index.php");

// office notes
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/main/onotes/office_comments.php");

// address book
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/usergroup/addrbook_list.php");

// order results
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/orders_results.php");

//http://localhost/openemr/interface/reports/index.php
//webview.loadUrl(getString(R.string.srv)+"/openemr");

// user validation (not sure how it is used)
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/login/validateUser.php");

// pending followup from results
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/pending_followup.php");

// pending orders
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/pending_orders.php");

// statistic reports
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/procedure_stats.php");

//order types and results
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/types.php");

// lab exchange system
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/orders/lab_exchange.php");

// add or edit drug
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/drugs/add_edit_drug.php");

//edit drug lot
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/drugs/add_edit_lot.php");

// destroy drug lot
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/drugs/destroy_lot.php");

// dispense drug
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/drugs/dispense_drug.php");

//drug inventory
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/drugs/drug_inventory.php");

// generate and print notes (needs printer driver)
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/CAMOS/notegen.php");

//patient encounter form
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/newpatient/view.php");

//create or edit work/school notes
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/note/new.php");v

//edit / print school/work notes
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/note/view.php");

// new dictation
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/dictation/new.php");

// view dictation
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/dictation/view.php");

// order procedure
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/procedure_order/new.php");

// view or change procedure
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/procedure_order/view.php");

// review of body systems
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/ros/view.php");

// review of body systems checked
//webview.loadUrl(getString(R.string.srv)+"/openemrinterface/forms/reviewofs/new.php");

//review patient vital stats
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/vitals/view.php");

// create patient vital stats instance
//webview.loadUrl(getString(R.string.srv)+"/openemr/interface/forms/vitals/new.php");


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





