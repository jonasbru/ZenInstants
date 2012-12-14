package com.majomi.zeninstants;

import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;

public class TabsListener implements TabListener {

	public SherlockFragment fragment;

	TabsListener(SherlockFragment fr) {
	    this.fragment= fr;
	}

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
    	transaction.replace(R.id.tabContent, fragment);
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
    	Log.d("DEBUG_TAG", "onTabUnselected " + fragment);
    }

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.d("DEBUG_TAG", "onTabReselected " + fragment);
	}
}
