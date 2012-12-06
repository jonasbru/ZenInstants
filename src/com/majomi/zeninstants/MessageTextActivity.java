package com.majomi.zeninstants;


import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.MessageTextView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MessageTextActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_text);
        retreiveMessageInfo();
        Display display = getWindowManager().getDefaultDisplay(); 
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();
        TextView msgScroll = (TextView) findViewById(R.id.Message_Text);
        msgScroll.setMovementMethod(ScrollingMovementMethod.getInstance());
        msgScroll.setMaxHeight((int)(height*0.65));
        msgScroll.setMaxWidth((int) (width*0.8));
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
