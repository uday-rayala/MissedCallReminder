package com.thoughtworks.missedcallreminder;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ReminderStartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent serviceIntent = new Intent(getApplicationContext(), ReminderService.class);
		
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getService(this, 0, serviceIntent, 0);
		alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 5 * 1000, 20 * 1000, pendingIntent);
		
		Toast.makeText(this, "Created service", Toast.LENGTH_LONG).show();
		this.finish();
	}

}
