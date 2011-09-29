package com.openemr;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity {

	SharedPreferences preferences;
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    addPreferencesFromResource(R.xml.prefrences);
	}
	//dummy code
	//private void SavePreferences(IP, String value){
	   //SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
	    //SharedPreferences.Editor editor = sharedPreferences.edit();
	    //editor.putString(key, value);
	    //editor.commit();
	   //}
}