/**
 * 
 */
package com.majomi.zeninstants;

import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageInterface;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


/**
 * 
 * Displays the historial.
 * For now, it's the initial activity
 *
 */
public class HistoricalActivity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historial_layout);
		ListView lv = (ListView) findViewById(R.id.historial_list);
		lv.setOnItemClickListener(mMessageClickedHandler);
	 	Historial_Adapter adapter = new Historial_Adapter(this);
	 	lv.setAdapter(adapter);
	}
	
	// Create a message handling witch manage the selection an item.
    private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
		@SuppressWarnings("rawtypes")
		public void onItemClick(AdapterView parent, View v, int position, long id) {
			Intent myIntent;
			Message_Manager msgMgr = Message_Manager.getMessageManager();
			MessageInterface msg = msgMgr.getMessage(position);
			
			if (msg instanceof MessageTextEntity ){
	        	myIntent = new Intent( getApplicationContext(), MessageTextActivity.class); 	
			}else if (msg instanceof MessageImageEntity ){
				myIntent = new Intent( getApplicationContext(), MessageImageActivity.class);
			}else if (msg instanceof MessageVideoEntity ){
				myIntent = new Intent( getApplicationContext(), MessageTextActivity.class);
			}else if (msg instanceof MessageSoundEntity ){
				myIntent = new Intent( getApplicationContext(), MessageTextActivity.class);
			}else{
				myIntent = new Intent( getApplicationContext(), MessageTextActivity.class);
			}
			
			myIntent.putExtra("MESSAGE_ID", (int)position);
            startActivityForResult(myIntent, 0);
        }
    };
}
