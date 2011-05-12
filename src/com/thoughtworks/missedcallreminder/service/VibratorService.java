package com.thoughtworks.missedcallreminder.service;

import android.content.Context;
import android.os.Vibrator;

import com.thoughtworks.missedcallreminder.ReminderApplicationContext;

public class VibratorService {
	private static Vibrator vibrator = (Vibrator) ReminderApplicationContext.getAppContext().getSystemService(Context.VIBRATOR_SERVICE);
	private static int vibrateInMilliSeconds = 2000;

	public static void vibrateOnPattern() {

		// This example will cause the phone to vibrate "SOS" in Morse Code
		// In Morse Code, "s" = "dot-dot-dot", "o" = "dash-dash-dash"
		// There are pauses to separate dots/dashes, letters, and words
		// The following numbers represent millisecond lengths
		int dot = 200; // Length of a Morse Code "dot" in milliseconds
		int dash = 500; // Length of a Morse Code "dash" in milliseconds
		int short_gap = 200; // Length of Gap Between dots/dashes
		int medium_gap = 500; // Length of Gap Between Letters
		int long_gap = 1000; // Length of Gap Between Words
		long[] pattern = { 0, // Start immediately
				dot, short_gap, dot, short_gap, dot, // s
				medium_gap, dash, short_gap, dash, short_gap, dash, // o
				medium_gap, dot, short_gap, dot, short_gap, dot, // s
				long_gap };

		// Only perform this pattern one time (-1 means "do not repeat")
		vibrator.vibrate(pattern, -1);
	}

	public static void vibrateSimple() {
		vibrator.vibrate(vibrateInMilliSeconds);
	}

	public static void vibrate() {
		// TODO BASED ON THE CUSTOMIZEATION THE VIBRATE NEEDS TO TRIGGER
		vibrateSimple();
	}
}
