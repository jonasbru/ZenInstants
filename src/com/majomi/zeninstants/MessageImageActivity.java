package com.majomi.zeninstants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.majomi.zeninstants.settingscontroller.HistorialManager;

public class MessageImageActivity extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_image);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		MessageButtonManager btnHandler = new MessageButtonManager(this);
		fillView();
	}    

	public void fillView(){
		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(HistorialManager.getHistorialManager().getMessage(msgId).getText());
		
		ImageView image = (ImageView) findViewById(R.id.message_image);           
		byte[] imageTile;
		 
		try {
			FileInputStream f = new FileInputStream(getCacheDir()+"taa");
			imageTile = readBytes(f);
			Bitmap bMap = BitmapFactory.decodeByteArray(imageTile, 0, imageTile.length);
			image.setImageBitmap(bMap);
			Log.d("ZEN","Image retreive");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_image, menu);
		return true;
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
