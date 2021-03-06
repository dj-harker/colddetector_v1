package com.example.davidfirstapp;

import com.example.davidfirstapp.R;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends MainActivity {

	private static final View activity_display_message = null;
	//When this activity is called, it displays text that informs the user of the temperatures outside
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
		// Show the Up button in the action bar.
		setupActionBar();
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		TextView textView = new TextView(this);
	    textView.setTextSize(24);
		if(PREFS_NAME == null)
		{
			textView.setText("Please set a temperature");
		}
		else
		{
		    textView.setText("The alarm is set for: " + getStoredTemperature() + "�F" + "\n" + "Current ambient temperature: " + 
			(int)(sensor.getAmbientTemperature())+ "�F" + "\n" + "Current battery temperature: " +  (int)(sensor.getBatteryTemperature()) + "�F" +
			"\n" + "Current location and temperature: " + getLocation(getApplicationContext()) + ": " + getRealTemperature()+"�F");
		}
	    setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
			
			case R.id.action_settings:
        	startActivity(new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS));
            return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
