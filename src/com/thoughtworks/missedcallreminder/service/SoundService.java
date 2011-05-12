package com.thoughtworks.missedcallreminder.service;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.thoughtworks.missedcallreminder.R;
import com.thoughtworks.missedcallreminder.ReminderApplicationContext;

public class SoundService {

	private static MediaPlayer mediaPlayer;

	public static void beep() {
		try{
		mediaPlayer= MediaPlayer.create(ReminderApplicationContext.getAppContext(), R.raw.beep6);
		mediaPlayer.setLooping(false);
		mediaPlayer.start();
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			public void onCompletion(MediaPlayer arg0) {
				if (mediaPlayer != null) {
					mediaPlayer.release();
					mediaPlayer = null;
				}
			}
		});
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alertBySound() {
		// TODO BASED ON THE CUSTOMIZEATION THE SOUND NEEDS TO CHANGE
		beep();
	}

}
