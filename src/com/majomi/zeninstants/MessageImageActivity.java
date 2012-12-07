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

        RelativeLayout globalLayout = (RelativeLayout) findViewById(R.id.Message_Main_Layout);
        globalLayout.setPadding((int) (width*0.04), (int)(height*0.07), (int) (width*0.04),(int) (height*0.07));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_message_image, menu);
        return true;
    }
}
