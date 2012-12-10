package com.majomi.zeninstants;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.majomi.zeninstants.messagescontroller.MessageManager;

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

        TextView text = (TextView) this.findViewById(R.id.Message_Text);
        
        text.setText(MessageManager.getMessageManager().get(msgId).getText());
		
    }
}
