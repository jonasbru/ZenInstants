/**
 * 
 */
package com.majomi.zeninstants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.HistorialViewsManager;
import com.majomi.zeninstants.settingscontroller.HistorialManager;
import com.majomi.zeninstants.utils.Utils;


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
<<<<<<< .merge_file_2upvM6
		
		Utils.setContext(this.getApplicationContext());

=======
		
		Utils.setContext(this.getApplicationContext());

>>>>>>> .merge_file_ZwCni8
		startService(new Intent(this,MessagesService.class));
		
		HistorialManager.getHistorialManager().loadMessages();

		setTheme(R.style.Theme_Sherlock);

		setContentView(R.layout.historial_layout);

		ListView lv = (ListView) findViewById(R.id.historial_list);
		lv.setOnItemClickListener(mMessageClickedHandler);
		HistorialAdapter adapter = new HistorialAdapter(this);
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
			
			MessageTextEntity msg = HistorialManager.getHistorialManager().getMessage(position);

			Class c = HistorialViewsManager.getHistorialViewsManager().getViewActionFromEntity(msg);

			Intent myIntent = new Intent(getApplicationContext(), c); 

			myIntent.putExtra("MESSAGE_ID", position);
			
			startActivityForResult(myIntent, 0);
		}
	};
	
}




