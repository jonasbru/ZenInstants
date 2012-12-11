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
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.settingscontroller.HistorialManager;
import com.majomi.zeninstants.utils.Utils;

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
		MessageImageEntity msg = (MessageImageEntity) HistorialManager.getHistorialManager().getMessage(msgId);
		
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(msg.getText());
		
		ImageView image = (ImageView) findViewById(R.id.message_image);
		if(Utils.loadDataAsImage(msg.getImage()) != null){
			AppLog.logString("Loading: " + msg.getImage());
			image.setImageBitmap(Utils.loadDataAsImage(msg.getImage()));
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_image, menu);
		return true;
	}	
}
