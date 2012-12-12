package com.majomi.zeninstants;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.actionbarsherlock.app.SherlockFragment;
import com.majomi.zeninstants.settingscontroller.Settings_Manager;
//import com.majomi.zeninstants.settingscontroller.Settings_Manager;

public class SettingsFragment extends SherlockFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_settings, container, false);
        final CheckBox cben = (CheckBox) v.findViewById(R.id.cb_enable_notification);
        final CheckBox cbt = (CheckBox) v.findViewById(R.id.cb_enabletext);
        final CheckBox cbp = (CheckBox) v.findViewById(R.id.cb_enablephotos);
        final CheckBox cbm = (CheckBox) v.findViewById(R.id.cb_enablemusic);
        final CheckBox cbv = (CheckBox) v.findViewById(R.id.cb_enablevideos);
        
        cben.setChecked(Settings_Manager.getSettingsManager().isNotifications_enabled());
        cbt.setChecked(Settings_Manager.getSettingsManager().isText_enabled());
        cbp.setChecked(Settings_Manager.getSettingsManager().isPhoto_enabled());
        cbm.setChecked(Settings_Manager.getSettingsManager().isMusic_enabled());
        cbv.setChecked(Settings_Manager.getSettingsManager().isVideo_enabled());
        
        //Listeners of the buttons
    	cben.setOnClickListener(new OnClickListener() {
     	  @Override
    	  public void onClick(View v) 
     	  {
     		  Settings_Manager.getSettingsManager().setNotifications_enabled(cben.isChecked());
          }
    	});
    	
    	cbt.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  Settings_Manager.getSettingsManager().setText_enabled(cbt.isChecked());
            }
      	});
        
    	cbp.setOnClickListener(new OnClickListener() {
         	  @Override
        	  public void onClick(View v) 
         	  {
         		  Settings_Manager.getSettingsManager().setPhoto_enabled(cbp.isChecked());
              }
        	});
               
    	cbm.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  Settings_Manager.getSettingsManager().setMusic_enabled(cbm.isChecked());
            }
      	});
    	
    	cbv.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  Settings_Manager.getSettingsManager().setVideo_enabled(cbv.isChecked());
            }
      	});
    	
    	 	
        return v;
    }    
  }
