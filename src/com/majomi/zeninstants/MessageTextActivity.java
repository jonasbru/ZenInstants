package com.majomi.zeninstants;


import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.MessageTextView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MessageTextActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_text);
        retreiveMessageInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_message_text, menu);
        return true;
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
