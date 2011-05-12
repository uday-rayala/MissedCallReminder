package com.thoughtworks.missedcallreminder.service;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.CallLog;
import android.widget.Toast;

public class ReminderService extends Service {
	private static final String CALL_LOG_URI = "content://call_log/calls";
	private final String MISSED_CALL_CONDITION = CallLog.Calls.TYPE + "=" + CallLog.Calls.MISSED_TYPE + " and " + CallLog.Calls.NEW + "=1";

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		// Toast.makeText(this, "Created", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// Toast.makeText(this, "Destoyed", Toast.LENGTH_LONG).show();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Toast.makeText(this, "Starting", Toast.LENGTH_SHORT).show();

		ContentResolver contentResolver = getApplicationContext().getContentResolver();
		Cursor cursor = contentResolver.query(Uri.parse(CALL_LOG_URI), null, MISSED_CALL_CONDITION, null, null);
		int numberOfMissedCalls = cursor.getCount();

//		Toast.makeText(this, "Showing", Toast.LENGTH_SHORT).show();
//		Toast.makeText(this, "Missed Calls : " + numberOfMissedCalls, Toast.LENGTH_LONG).show();
		if (numberOfMissedCalls > 0) {
			VibratorService.vibrate();
			SoundService.alertBySound();
		}
	
		return START_NOT_STICKY;
	}
}
