package com.majomi.zeninstants;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.settingscontroller.HistorialManager;

public class MessageTextActivity extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_text);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		fillView();
		MessageButtonManager btnHandler = new MessageButtonManager(this);
	}

	public void fillView(){
		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(HistorialManager.getHistorialManager().getMessage(msgId).getText());
	}
}
