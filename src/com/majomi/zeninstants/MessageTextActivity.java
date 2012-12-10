package com.majomi.zeninstants;



import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.MessageTextView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.Menu;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class MessageTextActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_message_text);
    	retreiveMessageInfo();
    	
    	//Display display = getWindowManager().getDefaultDisplay(); 
        //int width = display.getWidth();  // deprecated
        //int height = display.getHeight();
        //RelativeLayout globalLayout = (RelativeLayout) findViewById(R.id.Message_Main_Layout);
        //globalLayout.setPadding((int) (width*0.04), (int)(height*0.07), (int) (width*0.04),(int) (height*0.07));
        //TextView text = (TextView) findViewById(R.id.Message_Text);
        //text.setMinWidth((int)(300));//Hack for very small message
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
