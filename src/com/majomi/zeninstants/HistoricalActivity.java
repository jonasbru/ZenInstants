/**
 * 
 */
package com.majomi.zeninstants;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

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
	 	Historial_Adapter adapter = new Historial_Adapter(this);
	 	lv.setAdapter(adapter);
	}
}
