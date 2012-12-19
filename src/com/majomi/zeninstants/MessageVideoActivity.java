package com.majomi.zeninstants;

import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.majomi.zeninstants.messagescontroller.VideoManager;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.utils.Utils;

public class MessageVideoActivity extends SherlockActivity {

	private MessageVideoEntity entity;
	private VideoView video;
	private MediaController mc;
	private SherlockActivity act = this;
//	private ImageView startImage; // image to show instead of black background

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_message_video);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		
//		entity = (MessageVideoEntity) getIntent().getExtras().getSerializable("MESSAGE");
		
		entity = (MessageVideoEntity) Utils.getOriginalEntity(getIntent().getExtras().getString("msg_from"), getIntent().getExtras().getLong("msg_id"), getIntent().getExtras().getString("msg_type"));
//Log.d("CACA", entity + "");
//		startImage = (ImageView) findViewById(R.id.message_play_icon);
		
		fillView();

		new MessageButtonManager(this, entity);
	}

	public void fillView(){
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(entity.getText());

		ImageButton favorite = (ImageButton) this.findViewById(R.id.message_favorite_btn);
		if(entity.isFavorite()) {
			favorite.setImageResource(R.drawable.rating_favorite_red);
		} else {
			favorite.setImageResource(R.drawable.rating_favorite);			
		}

		video = (VideoView) findViewById(R.id.message_video);
		mc = new MediaController(act,true);
		
		//new StreamVideo(video).execute(entity.getVideo());

		mc.setAnchorView(video);
		video.setMediaController(mc);
		video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				//startImage.setVisibility(View.VISIBLE);
				//mp.reset(); //
				//video.setVideoURI(Uri.parse( VideoManager.getUrlVideoRTSP(urls[0])));
			}
		});
		String rstp = VideoManager.getUrlVideoRTSP(entity.getVideo());

		if (rstp.contains("://")) // hack if to check if it's a URL
			video.setVideoURI(Uri.parse( rstp));
		
		//startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?feature=player_detailpage&v=ykwqXuMPsoc")));

	}


	
	private class StreamVideo extends AsyncTask<String, Void, String> {
		VideoView imgView;

		public StreamVideo(VideoView imgView) {
			this.imgView = imgView;
		}


		protected String doInBackground(final String... urls) {

			/*video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					//startImage.setVisibility(View.VISIBLE);
					mp.reset(); //
					//video.setVideoURI(Uri.parse( VideoManager.getUrlVideoRTSP(urls[0])));
				}
			});
			
			*/


			video.setMediaController(mc);
			String rstp = VideoManager.getUrlVideoRTSP(entity.getVideo());
			
			
			return rstp;
		}

		@Override
		protected void onPostExecute(String rstp) {
			if (rstp.contains("://")) // hack if to check if it's a URL
				video.setVideoURI(Uri.parse( rstp));
			//mc.setAnchorView(video);
		}
		
	}
}
