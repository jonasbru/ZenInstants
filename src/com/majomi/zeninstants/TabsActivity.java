package com.majomi.zeninstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class TabsActivity extends SherlockFragmentActivity {

    private SherlockFragment historicalFragment= new HistoricalFragment();
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
        ActionBar.Tab historicalTab = actionBar.newTab();
        historicalTab.setText(R.string.title_tab_settings);
        settingsTab.setText(R.string.title_tab_historical);
        settingsTab.setTabListener(new TabsListener(settingsFragment));
        historicalTab.setTabListener(new TabsListener(historicalFragment));
        
        actionBar.addTab(historicalTab);
        actionBar.addTab(settingsTab); 
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
}
