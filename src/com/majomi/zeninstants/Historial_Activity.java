/**
 * 
 */
package com.majomi.zeninstants;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * Displays the historial.
 * For now, it's the initial activity
 *
 */
public class Historial_Activity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial_layout);
         
	    ListView lv = (ListView) findViewById(R.id.historial_list);
	    
	    ArrayList<String> title = new ArrayList<String>();
	    
	    for(int i = 0; i < 5; i++)
	    {
	    	title.add("Item nº = " + Integer.toString(i));
	    }
	    
	    lv.setAdapter(new ArrayAdapter<String>(getApplicationContext()
	    		, android.R.layout.simple_list_item_1, title));
    
	}
    

}
