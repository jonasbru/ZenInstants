package com.majomi.zeninstants;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.settingscontroller.HistorialManager;
import com.majomi.zeninstants.utils.Utils;

public class MessageImageActivity extends SherlockActivity {

	private MessageImageEntity entity;
	private ImageView imageView;
    private int defaultImage;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_message_image);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		entity = (MessageImageEntity) HistorialManager.getHistorialManager().getMessage(msgId);
		imageView = (ImageView) findViewById(R.id.message_image);
		defaultImage = R.drawable.templo_cerezo;
		fillView();

		new MessageButtonManager(this, entity);
	}

	public void fillView(){
		// Set the text
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(entity.getText());

		// Set the favorite button
		ImageButton favorite = (ImageButton) this.findViewById(R.id.message_favorite_btn);
		if(entity.isFavorite()) {
			favorite.setImageResource(R.drawable.rating_favorite_red);
		} else {
			favorite.setImageResource(R.drawable.rating_favorite);			
		}

		// Set the image
        Bitmap localImage = Utils.loadDataAsImage(entity.getLocalImage());
		if(localImage != null){ // Local image available
			AppLog.logString("Loading: " + entity.getLocalImage());
			imageView.setImageBitmap(localImage);
		}else{ // No local image
			new DownloadImageTask(imageView).execute(entity.getImageURL());
			AppLog.logString("Loading: " + entity.getImageURL());
		}
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_image, menu);
		return true;
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView imgView;

		public DownloadImageTask(ImageView imgView) {
			this.imgView = imgView;
		}

		
		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				AppLog.logError(e.getMessage());
				e.printStackTrace();
			}
			return mIcon;
		}

		protected void onPostExecute(Bitmap result) {
			if( result != null){
				AppLog.logString("Image downloaded");
				imgView.setImageBitmap(result);				
			}
			else {
				AppLog.logString("Default image used");
				imgView.setBackgroundResource(defaultImage);
			}	
		}
	}
}

