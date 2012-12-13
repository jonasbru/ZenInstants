package com.majomi.zeninstants;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.actionbarsherlock.app.SherlockFragment;
import com.majomi.zeninstants.settingscontroller.SettingsManager;
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
        
        cben.setChecked(SettingsManager.getSettingsManager().isNotificationsEnabled());
        cbt.setChecked(SettingsManager.getSettingsManager().isTextEnabled());
        cbp.setChecked(SettingsManager.getSettingsManager().isPhotoEnabled());
        cbm.setChecked(SettingsManager.getSettingsManager().isMusicEnabled());
        cbv.setChecked(SettingsManager.getSettingsManager().isVideoEnabled());
        
        //Listeners of the buttons
    	cben.setOnClickListener(new OnClickListener() {
     	  @Override
    	  public void onClick(View v) 
     	  {
     		  SettingsManager.getSettingsManager().setNotificationsEnabled(cben.isChecked());
          }
    	});
    	
    	cbt.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  SettingsManager.getSettingsManager().setTextEnabled(cbt.isChecked());
            }
      	});
        
    	cbp.setOnClickListener(new OnClickListener() {
         	  @Override
        	  public void onClick(View v) 
         	  {
         		  SettingsManager.getSettingsManager().setPhotoEnabled(cbp.isChecked());
              }
        	});
               
    	cbm.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  SettingsManager.getSettingsManager().setMusicEnabled(cbm.isChecked());
            }
      	});
    	
    	cbv.setOnClickListener(new OnClickListener() {
       	  @Override
      	  public void onClick(View v) 
       	  {
       		  SettingsManager.getSettingsManager().setVideoEnabled(cbv.isChecked());
            }
      	});
    	
    	 	
        return v;
    }    
  }
