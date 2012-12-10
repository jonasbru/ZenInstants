package com.majomi.zeninstants;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    	
    	ImageButton sButton = (ImageButton) v.findViewById(R.id.savebutton);
    	sButton.setOnClickListener(new OnClickListener() {
    		@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				TextView dMessages = (TextView) v.findViewById(R.id.daily_messages);
				String dMes = dMessages.getText().toString();
				try {
					int t = Integer.parseInt(dMes);
					if(t < 0) onFieldNegative(view);
					if(t > 99) onFieldExcedeedMaxium(view);
					if(t > 0 && t < 99) 
						Settings_Manager.getSettingsManager().setNotificationsPerDay(t);
				}
				catch (Exception e) {
//					// TODO: handle exception
					onFieldNotInteger(view);
				}
			}
			
			private void onFieldNotInteger(View view)
			{
				Toast.makeText(view.getContext(), "Insert a positive number", Toast.LENGTH_SHORT).show();
			}
			
			private void onFieldNegative(View view)
			{
				Toast.makeText(view.getContext(), "Insert a non negative number", Toast.LENGTH_SHORT).show();
			}
    		
			private void onFieldExcedeedMaxium(View view)
			{
				Toast.makeText(view.getContext(), "Insert a lower number", Toast.LENGTH_SHORT).show();
			}
			
    	});
    	
        return v;
    }    
  }
