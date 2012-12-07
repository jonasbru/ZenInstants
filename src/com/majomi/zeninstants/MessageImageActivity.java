package com.majomi.zeninstants;

import android.os.Bundle;
import android.app.Activity;
import android.view.Display;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MessageImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_image);
        
        Display display = getWindowManager().getDefaultDisplay(); 
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();
        TextView msgtxt = (TextView) findViewById(R.id.Message_Text);
        ImageView msgimg = (ImageView) findViewById(R.id.Message_Image);
        msgtxt.setMaxWidth((int) (width*0.85));
        msgimg.setMaxWidth((int) (width*0.85));
        RelativeLayout globalLayout = (RelativeLayout) findViewById(R.id.Message_Main_Layout);
        globalLayout.setPadding(0, (int)(height*0.07), 0,(int) (height*0.07));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_message_image, menu);
        return true;
    }
}
