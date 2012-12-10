package com.majomi.zeninstants;

import android.os.Bundle;
import android.view.WindowManager;
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
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_image, menu);
		return true;
	}


}
