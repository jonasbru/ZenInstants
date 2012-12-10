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
	    Toast.makeText(view.getContext(), name2, Toast.LENGTH_SHORT).show();
	    
	    if (on) {
	    	// Enable vibrate
	    	view.setBackgroundColor(view.getResources().getColor(R.color.dark_green));
	    } else {
	        // Disable vibrate
	    	view.setBackgroundColor(view.getResources().getColor(R.color.dark_red));
	    }
			
	}

}
