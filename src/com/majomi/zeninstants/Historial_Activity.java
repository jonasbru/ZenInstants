/**
 * 
 */
package com.majomi.zeninstants;

import java.util.ArrayList;
import java.util.HashMap;

import com.majomi.zeninstants.messages.Message_Manager;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

/**
 * 
 * Displays the historial.
 * For now, it's the initial activity
 *
 */
public class Historial_Activity extends ListActivity {
	
	ArrayList<HashMap<String,String>> historial = new ArrayList<HashMap<String,String>>();
	 
	String[] from=new String[] {"Text"};
	int[] to=new int[]{R.id.hmtext};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	 
	    super.onCreate(savedInstanceState);
	    

	    setContentView(R.layout.historial_layout);
	 
	    
	    
	    
	    ArrayList<String[]> list = new ArrayList<String[]>();
	 
	    Message_Manager messMan = Message_Manager.getMessageManager();
	    
	    String[] evento1 = messMan.textToHistorial(0);
	    list.add(evento1);
	 
	    String[] evento2 = messMan.textToHistorial(1);
	    list.add(evento2);
	 
	    String[] evento3 = messMan.textToHistorial(2);
	    list.add(evento3);
	 
	 
	    
	    for(int i = 0; i < list.size(); i++)
	    {
	    	HashMap<String,String> datas=new HashMap<String, String>();
	    	
	    	datas.put("Text", list.get(i)[0]);
	    	
	        historial.add(datas);
	    }
	    
	    
	    SimpleAdapter ListadoAdapter=new SimpleAdapter(this, historial, R.layout.historial_message_text, from, to);
	    setListAdapter(ListadoAdapter);
	    
	}
	    

}
