/**
 * 
 */
package com.majomi.zeninstants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.majomi.zeninstants.messagescontroller.MessageManager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.HistorialViewsManager;
import com.majomi.zeninstants.settingscontroller.HistorialManager;


/**
 * 
 * Displays the historial.
 * For now, it's the initial activity
 *
 */
public class HistoricalActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		startService(new Intent(this,MessagesService.class));
		
		HistorialManager.getHistorialManager().loadMessages(getPreferences(0));

		setTheme(R.style.Theme_Sherlock);

		setContentView(R.layout.historial_layout);

		ListView lv = (ListView) findViewById(R.id.historial_list);
		lv.setOnItemClickListener(mMessageClickedHandler);
		HistorialAdapter adapter = new HistorialAdapter(this);
		lv.setAdapter(adapter);

		Button myBtn=(Button) findViewById(R.id.hl_settings_button);

		myBtn.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						Intent i = new Intent(getApplicationContext(), TabsActivity.class);
						startActivity(i);
					}
				});
		AppLog.logString("SAVE");
		saveFile();
		AppLog.logString("SAVE DONE");
	}



	// Create a message handling witch manage the selection an item.
	private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
		@SuppressWarnings("rawtypes")
		public void onItemClick(AdapterView parent, View v, int position, long id) {
			
			MessageTextEntity msg = HistorialManager.getHistorialManager().getMessage(position);

			Class c = HistorialViewsManager.getHistorialViewsManager().getViewActionFromEntity(msg);

			Intent myIntent = new Intent(getApplicationContext(), c); 

			myIntent.putExtra("MESSAGE_ID", position);
			
			startActivityForResult(myIntent, 0);
		}
	};
	
	private void saveFile(){
		
		InputStream is = getResources().openRawResource(R.drawable.video_icon);
		byte[] bytes;
		try {
			bytes = readBytes(is);
			//FileOutputStream fos = openFileOutput("plop", Context.MODE_PRIVATE);
			
			//File outputDir = getCacheDir(); // context being the Activity pointer
			//File outputFile = File.createTempFile("prefix", "extension", outputDir);
			
			File f = new File(getCacheDir() + "taa");
			FileOutputStream fos = new FileOutputStream(f); //openFileOutput(getCacheDir()+"plop", Context.MODE_PRIVATE);
			
			fos.write(bytes);
			fos.close();
			Log.d("ZEN",f.getName()+" Files saved in " + getCacheDir());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ImageView image = (ImageView) findViewById(android.R.id.icon);           
Bitmap bMap = BitmapFactory.decodeByteArray(imageTile, 0, imageTile.length);
image.setImageBitmap(bMap);
		 */
//		InputStream bitmap=null;
//		
//		try {
//		    bitmap=getAssets().open("icon.png");
//		    Bitmap bit=BitmapFactory.decodeStream(bitmap);
//		    img.setImageBitmap(bit);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		} finally {
//		    bitmap.close();
//		}
	}
	
	public byte[] readBytes(InputStream inputStream) throws IOException {
		  // this dynamically extends to take the bytes you read
		  ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

		  // this is storage overwritten on each iteration with bytes
		  int bufferSize = 1024;
		  byte[] buffer = new byte[bufferSize];

		  // we need to know how may bytes were read to write them to the byteBuffer
		  int len = 0;
		  while ((len = inputStream.read(buffer)) != -1) {
		    byteBuffer.write(buffer, 0, len);
		  }

		  // and then we can return your byte array.
		  return byteBuffer.toByteArray();
		}
}




