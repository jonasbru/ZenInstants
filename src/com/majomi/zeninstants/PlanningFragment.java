//REMOVE ?
package com.majomi.zeninstants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.actionbarsherlock.app.SherlockFragment;
import com.majomi.zeninstants.settingscontroller.PlannerManager;

public class PlanningFragment extends SherlockFragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planning, container, false);
        
        for(int i = 0; i < 24; i++)
        {
        	this.initialitzeToggleButton(v, R.id.mon0+i, 0, i);
        	this.initialitzeToggleButton(v, R.id.tue0+i, 1, i);
        	this.initialitzeToggleButton(v, R.id.wen0+i, 2, i);
        	this.initialitzeToggleButton(v, R.id.thu0+i, 3, i);
        	this.initialitzeToggleButton(v, R.id.fri0+i, 4, i);
        	this.initialitzeToggleButton(v, R.id.sat0+i, 5, i);
        	this.initialitzeToggleButton(v, R.id.sun0+i, 6, i);
        }	
        
        return v;
    }
	
		
	public void initialitzeToggleButton(View v, int id, int day, int hour)
	{
		
		ToggleButton b1 = (ToggleButton) v.findViewById(id);
		b1.setChecked(PlannerManager.getPlannerManager().getWeek().get(day).get(hour));
	}
	
		
}
