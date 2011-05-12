package com.thoughtworks.missedcallreminder;

import android.app.Application;
import android.content.Context;

public class ReminderApplicationContext extends Application {
	private static Context context;

	public void onCreate() {
		context = getApplicationContext();
	}

	public static Context getAppContext(){
		return context;
	}
}
