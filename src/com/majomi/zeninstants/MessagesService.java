package com.majomi.zeninstants;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.Vibrator;
import android.util.Log;

import com.majomi.zeninstants.messagescontroller.MessageManager;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.messagesviews.HistorialViewsManager;
import com.majomi.zeninstants.settingscontroller.HistorialManager;
import com.majomi.zeninstants.settingscontroller.SettingsManager;
import com.majomi.zeninstants.utils.Utils;

public class MessagesService extends Service {
	TimeUtils timer = new TimeUtils();

	@Override
	public void onCreate() {
		super.onCreate();

		//Create some stuff here
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		AppLog.logString("Service: Created");
		Thread t = new Thread(){
			public void run(){
				startSendingMessages();
			}
		};
		t.start();

		Thread t2 = new Thread(){
			public void run(){
				startUpdatingPhrases();
			}
		};
		t2.start();
		return START_STICKY;
	}

	/**
	 * Send messages to the user
	 */
	@SuppressWarnings("rawtypes")
	public void startSendingMessages() {
		for(int i = 0; i < 0; i++){
			synchronized (this){
				timer.noisyWait(10000);
			}

			if(SettingsManager.getSettingsManager().isNotifications_enabled()) {
				MessageTextEntity message = MessageManager.getMessageManager().getRandomMessage();

				if(message != null) {
					Log.d("ZEN", "New message pop ! " + i);
					
					Class c = HistorialViewsManager.getHistorialViewsManager().getViewActionFromEntity(message);

					Intent dialogIntent = new Intent(getBaseContext(), c);

					dialogIntent.putExtra("msg_from", "m");
					dialogIntent.putExtra("msg_id", message.getId());
					if(message.getClass() == MessageTextEntity.class) {
						dialogIntent.putExtra("msg_type", "t");
					} else if(message.getClass() == MessageImageEntity.class) {
						dialogIntent.putExtra("msg_type", "i");
					} else if(message.getClass() == MessageSoundEntity.class) {
						dialogIntent.putExtra("msg_type", "s");
					} else if(message.getClass() == MessageVideoEntity.class) {
						dialogIntent.putExtra("msg_type", "o");
					}
					
//					dialogIntent.putExtra("MESSAGE", message);

					dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

					getApplication().startActivity(dialogIntent);

					HistorialManager.getHistorialManager().addMessage(message);

					vibrate();
				}
			}
		}
	}

	public void startUpdatingPhrases() {
		Looper.prepare();
		while(true) {
			Utils.setContext(getApplicationContext());
			NetworkManager.updatePhrases();
			try {
				synchronized (this) {
					wait(24*60*60*1000); //1 Day
				}
			} catch (InterruptedException e) {
				Log.e("Updating messages error", "InterruptedException !!", e);
			} 
		}
	}

	public void vibrate(){
		// Get instance of Vibrator from current Context
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		long[] pattern = {0,300};

		// Only perform this pattern one time (-1 means "do not repeat")
		v.vibrate(pattern, -1);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}