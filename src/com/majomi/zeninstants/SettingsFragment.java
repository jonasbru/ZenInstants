package com.majomi.zeninstants;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class SettingsFragment extends SherlockFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        final CheckBox cben = (CheckBox) v.findViewById(R.id.cb_enable_notification);
    	cben.setOnClickListener(new OnClickListener() {
     
    	  @Override
    	  public void onClick(View v) {
                
    		if (cben.isChecked()) {
    			Toast.makeText(v.getContext(),
    		 	   "Is checked", Toast.LENGTH_LONG).show();
    		}
    		else
    		{
    			Toast.makeText(v.getContext().getApplicationContext(),
    	    		 	   "Is not checked", Toast.LENGTH_LONG).show();
    		}
     
    	  }
    	});
    
        return v;
    }
    
  }
