package com.majomi.zeninstants;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MessageImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_image);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_message_image, menu);
        return true;
    }
}
