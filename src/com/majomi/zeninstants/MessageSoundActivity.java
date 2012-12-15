package com.majomi.zeninstants;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.settingscontroller.HistorialManager;


public class MessageSoundActivity extends SherlockActivity {

	private MessageSoundEntity entity;
	private ImageButton soundButton;
	private MediaPlayer soundPlayer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_message_sound);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		entity = (MessageSoundEntity) HistorialManager.getHistorialManager().getMessage(msgId);

		soundButton = (ImageButton)findViewById(R.id.message_sound);
		soundButton.setOnClickListener(playListener);

		fillView();

		new MessageButtonManager(this, entity);
	}

	public void fillView() {
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(entity.getText());

		ImageButton favorite = (ImageButton) this.findViewById(R.id.message_favorite_btn);
		if(entity.isFavorite()) {
			favorite.setImageResource(R.drawable.rating_favorite_red);
		} else {
			favorite.setImageResource(R.drawable.rating_favorite);			
		}

		try {
			AppLog.logString(entity.getSound());
			soundPlayer = new MediaPlayer();
			soundPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			soundPlayer.setDataSource(this, Uri.parse(entity.getSound()));
			soundPlayer.prepare(); // To put in asynchrone
		} catch (IllegalStateException e) {
			AppLog.logError("Can't load sound");
			e.printStackTrace();
		} catch (IOException e) {
			AppLog.logString("Can't load sound");
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_sound, menu);
		return true;
	}

	private OnClickListener playListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			playSong();
		}
	};

	private void playSong() {
		if(soundPlayer.isPlaying()){
			soundButton.setImageResource(R.drawable.av_play);
			soundPlayer.pause();
		}
		else{
			soundButton.setImageResource(R.drawable.av_pause);
			soundPlayer.start();
		}
	}

	@Override
	public void onPause()
	{
		soundPlayer.pause();
		soundButton.setImageResource(R.drawable.av_play);
		super.onPause();
	}
}
