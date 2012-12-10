package com.majomi.zeninstants;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MessageSoundActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_sound);
        MessageButtonHandler btnHandler = new MessageButtonHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_message_sound, menu);
        return true;
    }
}
