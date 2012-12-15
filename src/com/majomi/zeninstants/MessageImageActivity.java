/*package com.majomi.zeninstants;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagescontroller.ImageManager;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
*/
package com.majomi.zeninstants;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagescontroller.ImageManager;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;

public class MessageImageActivity extends SherlockActivity {

	private MessageImageEntity entity;
	private ImageView imageView;
	private Bitmap image;
	private Context context = this;
	ProgressBar loading;
	ImageManager imgMgr = ImageManager.getImageManager();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		imgMgr.setContext(context);
		setContentView(R.layout.activity_message_image);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		entity = (MessageImageEntity) getIntent().getExtras().getSerializable("MESSAGE");

		imageView = (ImageView) findViewById(R.id.message_image);
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
		ImageManager imgMgr = ImageManager.getImageManager();
		String file = entity.getLocalImage();

		image = imgMgr.loadDataAsImage(file);
		if(image != null){  // if there is a local image
			imageView.setImageBitmap(image);
			if(imgMgr.isAnInternalFile(file)){// We have to move the file
				// Move the file
				new MoveImageTask().execute(file);
			}
		} else { // Try to download the image
			AppLog.logString("Loading: " + entity.getImageURL());
			new DownloadImageTask(imageView).execute(entity.getImageURL());
		}
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView imgView;

		public DownloadImageTask(ImageView imgView) {
			this.imgView = imgView;
		}

		protected void onPreExecute(){
			loading = (ProgressBar) findViewById(R.id.message_loading);
			loading.setVisibility(View.VISIBLE);
			//imgView.setAnimation()ImageBitmap(result);
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon = null;
			try {
				//InputStream in = new java.net.URL(urldisplay).openStream();
				InputStream in = (InputStream) new URL(urldisplay).getContent();
				mIcon = BitmapFactory.decodeStream(in);

				//entity.setLocalImage(imgMgr.saveCacheData(in));
				entity.setLocalImage(imgMgr.saveCacheData(mIcon));
			} catch (Exception e) {
				AppLog.logError("Impossible to store image from" + urldisplay);
				e.printStackTrace();
			}

			return mIcon;
		}

		protected void onPostExecute(Bitmap result) {
			AppLog.logString("plop");
			loading = (ProgressBar) findViewById(R.id.message_loading);
			loading.setVisibility(View.GONE);
			if( result != null){
				image = result;
				imgView.setImageBitmap(result);

			}
			else {
				AppLog.logString("Default image used");
			}	
		}
	}

	private class MoveImageTask extends AsyncTask<String, Void, String[]> {

		protected String[] doInBackground(String... files) {
			String file = files[0];
			String[] toppings = {imgMgr.moveToCache(file),file};
			return toppings;

		}

		protected void onPostExecute(String[] files) {
			entity.setLocalImage(files[0]);
			if(files[0] == null)
				AppLog.logError("Imopssible to move to: " + files[1]);
			else
				AppLog.logString("File moved from " + files[1] + "\nto " + files[0]);
		}
	}
}

/*
public class MessageImageActivity extends SherlockActivity {

	private MessageImageEntity entity;
	private ImageView imageView;
	private Bitmap image;
	private Context context = this;
	ProgressBar loading;
	ImageManager imgMgr = ImageManager.getImageManager();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		imgMgr.setContext(context);
		setContentView(R.layout.activity_message_image);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		entity = (MessageImageEntity) getIntent().getExtras().getSerializable("MESSAGE");

		imageView = (ImageView) findViewById(R.id.message_image);
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
		ImageManager imgMgr = ImageManager.getImageManager();
		String file = entity.getLocalImage();

		image = imgMgr.loadDataAsImage(file);
		if(image != null){  // if there is a local image
			imageView.setImageBitmap(image);
			if(imgMgr.isAnInternalFile(file)){// We have to move the file
				// Move the file
				new MoveImageTask().execute(file);
			}
		} else { // Try to download the image
			AppLog.logString("Loading: " + entity.getImageURL());
			new DownloadImageTask(imageView).execute(entity.getImageURL());
		}
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView imgView;

		public DownloadImageTask(ImageView imgView) {
			this.imgView = imgView;
		}

		@Override
		protected void onPreExecute(){
			AppLog.logString("Pre");
			loading = (ProgressBar) findViewById(R.id.message_loading);
			loading.setVisibility(View.VISIBLE);
			//imgView.setAnimation()ImageBitmap(result);
		}

		@Override
		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon = null;
			try {
				//InputStream in = new java.net.URL(urldisplay).openStream();
				InputStream in = (InputStream) new URL(urldisplay).getContent();
				mIcon = BitmapFactory.decodeStream(in);
				
				//entity.setLocalImage(imgMgr.saveCacheData(in));
				AppLog.logString("Coucou2");
				entity.setLocalImage(imgMgr.saveCacheData(mIcon));
				AppLog.logString("Coucou3");
			} catch (Exception e) {
				AppLog.logError("Impossible to store image from" + urldisplay);
				e.printStackTrace();
			}
			
			return mIcon;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			AppLog.logString("Post");
			loading = (ProgressBar) findViewById(R.id.message_loading);
			loading.setVisibility(View.GONE);
			if( result != null){
				image = result;
				imgView.setImageBitmap(result);
				
			}
			else {
				AppLog.logString("Default image used");
			}	
		}
	}
	
	private class MoveImageTask extends AsyncTask<String, Void, String[]> {

		protected String[] doInBackground(String... files) {
			String file = files[0];
			String[] toppings = {imgMgr.moveToCache(file),file};
			return toppings;
			
		}
		
		protected void onPostExecute(String[] files) {
			entity.setLocalImage(files[0]);
			if(files[0] == null)
				AppLog.logError("Imopssible to move to: " + files[1]);
			else
				AppLog.logString("File moved from " + files[1] + "\nto " + files[0]);
		}
	}
}
*/
