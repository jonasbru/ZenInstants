package com.majomi.zeninstants;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesviews.MessageTextView;

public class MessageTextActivity extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_text);
		retreiveMessageInfo();
		MessageButtonManager btnHandler = new MessageButtonManager(this);
	}


	/**
	 * Fill all the field according to the message selected
	 */
	public void retreiveMessageInfo(){
		int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
		Message_Manager bm = Message_Manager.getMessageManager();
		MessageTextView b = (MessageTextView) bm.getMessageView(msgId); 
		b.fillMessageView(this);
	}
}
