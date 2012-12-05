/**
 * 
 */
package com.majomi.zeninstants;



import com.majomi.zeninstants.messagescontroller.Message_Manager;

import android.app.Activity;
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
public class Historial_Activity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.historial_layout);    
	    ListView lv = (ListView) findViewById(R.id.historial_list);
	    Historial_Adapter adapter = new Historial_Adapter(this);
	    lv.setAdapter(adapter);
	    
	    lv.setOnItemClickListener(
        		new OnItemClickListener() 
        		{
        			public void onItemClick(AdapterView parent, View v, int pos, long id)
        			{
        				Message_Manager.getMessageManager().getMessage(pos).onItemSelected(getApplicationContext());
        			}
				}
        );
        
	}
}
