package com.thoughtworks.missedcallreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReminderBootReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Intent serviceIntent = new Intent();
		serviceIntent.setAction("com.thoughtworks.missedcallreminder.ReminderService");

	}

}
