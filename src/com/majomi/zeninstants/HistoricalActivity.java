/**
 * 
 */
package com.majomi.zeninstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		
		Utils.setContext(this.getApplicationContext());

		startService(new Intent(this,MessagesService.class));

		HistorialManager.getHistorialManager().loadMessages();
		
		setTheme(R.style.Theme_Sherlock);

		setContentView(R.layout.historial_layout);

		ListView lv = (ListView) findViewById(R.id.historial_list);
		lv.setOnItemClickListener(mMessageClickedHandler);

        HistorialAdapter adapter = new HistorialAdapter(this);
	 	lv.setAdapter(adapter);
	 	
	 }
	
	// Create a message handling witch manage the selection an item.
	private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
		@SuppressWarnings("rawtypes")
		public void onItemClick(AdapterView parent, View v, int position, long id) {
			
			MessageTextEntity msg = HistorialManager.getHistorialManager().getMessage(position);

			Class c = HistorialViewsManager.getHistorialViewsManager().getViewActionFromEntity(msg);

			Intent myIntent = new Intent(getApplicationContext(), c); 
			
			myIntent.putExtra("MESSAGE_ID", (int)position);
            startActivityForResult(myIntent, 0);
        }
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.activity_historial, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.historial_menu_settings:
            	Intent i = new Intent(this, TabsActivity.class);
				startActivity(i);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}




