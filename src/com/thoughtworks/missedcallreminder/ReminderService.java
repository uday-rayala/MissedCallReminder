package com.thoughtworks.missedcallreminder;

import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.Vibrator;
import android.provider.CallLog;
import android.widget.Toast;

public class ReminderService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "Created", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "Destoyed", Toast.LENGTH_LONG).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();
		
		ContentResolver contentResolver = getApplicationContext().getContentResolver();
		Cursor cursor = contentResolver.query(Uri.parse("content://call_log/calls"), null, CallLog.Calls.TYPE + "=" + CallLog.Calls.MISSED_TYPE + " and " + CallLog.Calls.NEW + "=1", null, null);
		int numberOfMissedCalls = cursor.getCount();
		
		Toast.makeText(this, "Showing", Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "Missed Calls : "+numberOfMissedCalls, Toast.LENGTH_LONG).show();
		if (numberOfMissedCalls > 0){
			// Get instance of Vibrator from current Context
			Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
			 
			// This example will cause the phone to vibrate "SOS" in Morse Code
			// In Morse Code, "s" = "dot-dot-dot", "o" = "dash-dash-dash"
			// There are pauses to separate dots/dashes, letters, and words
			// The following numbers represent millisecond lengths
			int dot = 200;      // Length of a Morse Code "dot" in milliseconds
			int dash = 500;     // Length of a Morse Code "dash" in milliseconds
			int short_gap = 200;    // Length of Gap Between dots/dashes
			int medium_gap = 500;   // Length of Gap Between Letters
			int long_gap = 1000;    // Length of Gap Between Words
			long[] pattern = {
			    0,  // Start immediately
			    dot, short_gap, dot, short_gap, dot,    // s
			    medium_gap,
			    dash, short_gap, dash, short_gap, dash, // o
			    medium_gap,
			    dot, short_gap, dot, short_gap, dot,    // s
			    long_gap
			};
			 
			// Only perform this pattern one time (-1 means "do not repeat")
//			v.vibrate(pattern, -1);
			v.vibrate(1000);

		}
		return START_NOT_STICKY;
	}
}
