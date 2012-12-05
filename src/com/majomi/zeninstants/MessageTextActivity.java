package com.majomi.zeninstants;


import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;

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
     * Fill all the field according to the book selected
     */
    public void retreiveMessageInfo(){
    	int msgId = getIntent().getExtras().getInt("MESSAGE_ID");
        Message_Manager bm = Message_Manager.getMessageManager();
        MessageTextEntity b = (MessageTextEntity) bm.getMessage(msgId);
        
        TextView text = (TextView) findViewById(R.id.MT_Text);
        text.setText(b.getText());
    }
}
