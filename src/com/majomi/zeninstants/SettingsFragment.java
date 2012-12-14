package com.majomi.zeninstants;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.majomi.zeninstants.settingscontroller.SettingsManager;

public class SettingsFragment extends SherlockFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    
	@TargetApi(14)
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	final View v = inflater.inflate(R.layout.fragment_settings, container, false);
        
    	if(Build.VERSION.SDK_INT >= 14)
    	{
    		Switch enableNotifications = (Switch) v.findViewById(R.id.notifswitch);
    		enableNotifications.setChecked(SettingsManager.getSettingsManager().isNotifications_enabled());
    		
    		enableNotifications.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					SettingsManager.getSettingsManager().setNotifications_enabled(isChecked);
					
				}
			});
    		
    		Switch textMessages = (Switch) v.findViewById(R.id.textmesswitch);
    		textMessages.setChecked(SettingsManager.getSettingsManager().isText_enabled());
    		
    		textMessages.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					SettingsManager.getSettingsManager().setText_enabled(isChecked);
					
				}
			});
    		
    		Switch photoMessages = (Switch) v.findViewById(R.id.photomesswitch);
    		photoMessages.setChecked(SettingsManager.getSettingsManager().isPhoto_enabled());
    		
    		photoMessages.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					SettingsManager.getSettingsManager().setPhoto_enabled(isChecked);
					
				}
			});
    		
    		Switch musicMessages = (Switch) v.findViewById(R.id.musicswitch);
    		musicMessages.setChecked(SettingsManager.getSettingsManager().isMusic_enabled());
    		
    		musicMessages.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					SettingsManager.getSettingsManager().setMusic_enabled(isChecked);
					
				}
			});
    		
    		Switch videoMessages = (Switch) v.findViewById(R.id.videoswitch);
    		videoMessages.setChecked(SettingsManager.getSettingsManager().isVideo_enabled());
    		
    		videoMessages.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					SettingsManager.getSettingsManager().setVideo_enabled(isChecked);
					
				}
			});
    		
    		
    	}
    	else
    	{
    	
    		final CheckBox cben = (CheckBox) v.findViewById(R.id.cb_enable_notification);
            final CheckBox cbt = (CheckBox) v.findViewById(R.id.cb_enabletext);
            final CheckBox cbp = (CheckBox) v.findViewById(R.id.cb_enablephotos);
            final CheckBox cbm = (CheckBox) v.findViewById(R.id.cb_enablemusic);
            final CheckBox cbv = (CheckBox) v.findViewById(R.id.cb_enablevideos);
            
            cben.setChecked(SettingsManager.getSettingsManager().isNotifications_enabled());
            cbt.setChecked(SettingsManager.getSettingsManager().isText_enabled());
            cbp.setChecked(SettingsManager.getSettingsManager().isPhoto_enabled());
            cbm.setChecked(SettingsManager.getSettingsManager().isMusic_enabled());
            cbv.setChecked(SettingsManager.getSettingsManager().isVideo_enabled());
         
                    
            //Listeners of the buttons
        	cben.setOnClickListener(new OnClickListener() {
         	  @Override
        	  public void onClick(View v) 
         	  {
         		  SettingsManager.getSettingsManager().setNotifications_enabled(cben.isChecked());
              }
        	});
        	
        	cbt.setOnClickListener(new OnClickListener() {
           	  @Override
          	  public void onClick(View v) 
           	  {
           		  SettingsManager.getSettingsManager().setText_enabled(cbt.isChecked());
                }
          	});
            
        	cbp.setOnClickListener(new OnClickListener() {
             	  @Override
            	  public void onClick(View v) 
             	  {
             		  SettingsManager.getSettingsManager().setPhoto_enabled(cbp.isChecked());
                  }
            	});
                   
        	cbm.setOnClickListener(new OnClickListener() {
           	  @Override
          	  public void onClick(View v) 
           	  {
           		  SettingsManager.getSettingsManager().setMusic_enabled(cbm.isChecked());
                }
          	});
        	
        	cbv.setOnClickListener(new OnClickListener() {
           	  @Override
          	  public void onClick(View v) 
           	  {
           		  SettingsManager.getSettingsManager().setVideo_enabled(cbv.isChecked());
                }
          	});
        
    		
    	}
    	
    	//Seek bar details initialization
        SeekBar bar = (SeekBar) v.findViewById(R.id.seekBar1);
		final TextView stressLvl = (TextView) v.findViewById(R.id.textViewProgress);
        // initialitze position of progress
        int progress = 1;
        int sl = SettingsManager.getSettingsManager().getStressLevel();
        if (sl == 0){
        	progress = 1; 
        	stressLvl.setText("Select your stress");
        }
        if (sl == 1){ 
        	progress = 1; 
        	stressLvl.setText("Low stress"); 
        }
        if (sl == 2){ 
        	progress = 40; 
        	stressLvl.setText("Mid stress"); 
        }
        if (sl == 3){ 
        	progress = 70; 
        	stressLvl.setText("High stress"); 
        }
        if (sl == 4){ 
        	progress = 100; 
        	stressLvl.setText("Very high stress"); 
        }
        bar.setProgress(progress);
        
        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
				if(progress <= 30) { 
					stressLvl.setText("Low stress");
					SettingsManager.getSettingsManager().setStressLevel(1);
				}
				if(progress > 30 && progress <= 60 ) {
					stressLvl.setText("Mid stress");
					SettingsManager.getSettingsManager().setStressLevel(2);
				}
				if(progress > 60 && progress <= 90 ) { 
					stressLvl.setText("High stress");
					SettingsManager.getSettingsManager().setStressLevel(3);
				}
				if(progress > 90) {
					stressLvl.setText("Very high stress");
					SettingsManager.getSettingsManager().setStressLevel(4);
				}
				SettingsManager.getSettingsManager().setNotificationsPerDayStressLevel();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});	

        
        return v;
    }
    
  }
