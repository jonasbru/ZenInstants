package com.majomi.zeninstants;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_message_image);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		entity = (MessageImageEntity) HistorialManager.getHistorialManager().getMessage(msgId);

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

		ImageView image = (ImageView) findViewById(R.id.message_image);
		if(Utils.loadDataAsImage(entity.getLocalImage()) != null){
			AppLog.logString("Loading: " + entity.getLocalImage());
			image.setImageBitmap(Utils.loadDataAsImage(entity.getLocalImage()));
		}else{
			AppLog.logString("Image not found: " + entity.getLocalImage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_image, menu);
		return true;
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
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
			bmImage.setImageBitmap(result);
		}
	}
}

