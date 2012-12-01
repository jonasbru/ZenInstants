/**
 * 
 */
package com.majomi.zeninstants;

import android.app.Activity;
import android.os.Bundle;
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
	}
}
