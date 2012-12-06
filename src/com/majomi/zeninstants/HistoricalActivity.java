/**
 * 
 */
package com.majomi.zeninstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesviews.MessageImageView;
import com.majomi.zeninstants.messagesviews.MessageSoundView;
import com.majomi.zeninstants.messagesviews.MessageTextView;
import com.majomi.zeninstants.messagesviews.MessageVideoView;
import com.majomi.zeninstants.messagesviews.MessageView;


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
		setTheme(R.style.Theme_Sherlock);
		setContentView(R.layout.historial_layout);
		ListView lv = (ListView) findViewById(R.id.historial_list);
		lv.setOnItemClickListener(mMessageClickedHandler);
	 	Historial_Adapter adapter = new Historial_Adapter(this);
	 	lv.setAdapter(adapter);
	 	
	 	Button myBtn=(Button) findViewById(R.id.hl_settings_button);
	    
	      myBtn.setOnClickListener(
	    		  new View.OnClickListener() {
	    			  public void onClick(View v) {
	    				  Intent i = new Intent(getApplicationContext(), TabsActivity.class);
	    				  startActivity(i);
	    			  }
	    		  });
	}
	
	
	
	// Create a message handling witch manage the selection an item.
    private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
		@SuppressWarnings("rawtypes")
		public void onItemClick(AdapterView parent, View v, int position, long id) {
			Intent myIntent;
			Message_Manager msgMgr = Message_Manager.getMessageManager();
			MessageView msg = msgMgr.getMessageView(position);
			
			if (msg instanceof MessageTextView ){
	        	myIntent = new Intent( getApplicationContext(), MessageTextActivity.class); 	
			}else if (msg instanceof MessageImageView ){
				myIntent = new Intent( getApplicationContext(), MessageImageActivity.class);
			}else if (msg instanceof MessageVideoView ){
				myIntent = new Intent( getApplicationContext(), MessageVideoActivity.class);
			}else if (msg instanceof MessageSoundView ){
				myIntent = new Intent( getApplicationContext(), MessageSoundActivity.class);
			}else{
				myIntent = new Intent( getApplicationContext(), MessageTextActivity.class);//Not working
			}
			
			myIntent.putExtra("MESSAGE_ID", (int)position);
            startActivityForResult(myIntent, 0);
        }
    };
}
