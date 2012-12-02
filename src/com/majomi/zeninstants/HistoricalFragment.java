/**
 * 
 */
package com.majomi.zeninstants;

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
public class HistoricalFragment extends SherlockFragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	}
	
	 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment and fill it with an adapter
        View v = inflater.inflate(R.layout.historial_layout, container, false);
        ListView lv = (ListView) v.findViewById(R.id.historial_list);
        Historial_Adapter adapter = new Historial_Adapter(getActivity());
        lv.setAdapter(adapter);

        Log.d("DEBUG_TAG", "Collection created");
        
        return v;
    }
}
