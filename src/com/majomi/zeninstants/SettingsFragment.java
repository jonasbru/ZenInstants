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
        CheckBox cbt = (CheckBox) v.findViewById(R.id.cb_enabletext);
        CheckBox cbp = (CheckBox) v.findViewById(R.id.cb_enablephotos);
        CheckBox cbm = (CheckBox) v.findViewById(R.id.cb_enablemusic);
        CheckBox cbv = (CheckBox) v.findViewById(R.id.cb_enablevideos);
        
    	cben.setOnClickListener(new OnClickListener() {
     	  @Override
    	  public void onClick(View v) 
     	  {
          }
    	});
        return v;
    }
    
  }
