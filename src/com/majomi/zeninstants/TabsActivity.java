package com.majomi.zeninstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.majomi.zeninstants.settingscontroller.Planner_Manager;

public class TabsActivity extends SherlockFragmentActivity {

    private SherlockFragment planningFragment= new PlanningFragment();
    private SherlockFragment settingsFragment= new SettingsFragment();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	setTheme(R.style.Theme_Sherlock);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        
        //Create the 2 tabs
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
         
        ActionBar.Tab settingsTab = actionBar.newTab();
        ActionBar.Tab planningTab = actionBar.newTab();
        planningTab.setText(R.string.title_tab_planning);
        settingsTab.setText(R.string.title_tab_settings);
        settingsTab.setTabListener(new TabsListener(settingsFragment));
        planningTab.setTabListener(new TabsListener(planningFragment));
        
        
        actionBar.addTab(settingsTab);
        actionBar.addTab(planningTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_tabs, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        
        //respond to menu item selection
    	switch (item.getItemId()) {
    	//TODO
        default:
        return super.onOptionsItemSelected(item);
    	}
    }
 
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK)
		{
			//TODO
		}
	}
    
    public void onToggleClicked(View view) {
	    // Is the toggle on?
	    boolean on = ((ToggleButton) view).isChecked();
	    
	    String name = getResources().getResourceName(view.getId()).toString();
	    String name2 = name.substring(name.indexOf("/")+1);
	    
	    String sday = name2.substring(0, 3);
	    String shour = name2.substring(3);
	    
	    int day = -1;
	    
	    if(sday.compareToIgnoreCase("mon") == 0) day = 0;
	    if(sday.compareToIgnoreCase("tue") == 0) day = 1;
	    if(sday.compareToIgnoreCase("wen") == 0) day = 2;
	    if(sday.compareToIgnoreCase("thu") == 0) day = 3;
	    if(sday.compareToIgnoreCase("fri") == 0) day = 4;
	    if(sday.compareToIgnoreCase("sat") == 0) day = 5;
	    if(sday.compareToIgnoreCase("sun") == 0) day = 6;
	    
	    if(day == -1)
	    	Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();
	    else
	    {
	    	int hour = Integer.parseInt(shour);
	    
		    if (on) {
		    	// Enable vibrate
		    	Planner_Manager.getPlannerManager().getWeek().get(day).set(hour, true);
		    } else {
		        // Disable vibrate
		    	Planner_Manager.getPlannerManager().getWeek().get(day).set(hour, false);
		    }
	    }
			
	}

}
