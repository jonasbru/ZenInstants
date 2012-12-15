package com.majomi.zeninstants.settingscontroller;

import java.util.ArrayList;
import java.util.Random;

import com.majomi.zeninstants.utils.Utils;

public class PlannerManager {

	static private PlannerManager plannerManager = null;
	
	private ArrayList<ArrayList<Boolean>> week;

	@SuppressWarnings("unchecked")
	public PlannerManager()
	{
		this.week = (ArrayList<ArrayList<Boolean>>) Utils.getObjectFromSharedPreferences("plannerManagerWeek");

		if(this.week == null) {
			this.week = new ArrayList<ArrayList <Boolean>>();
			for(int i = 0; i < 7; i++){
				this.week.add(new ArrayList <Boolean>());
				for(int j = 0; j < 24; j++)
					this.week.get(i).add(false);
			}
		
		}
	}
	
	static public PlannerManager getPlannerManager()
	{
		if(plannerManager == null) plannerManager = new PlannerManager();
		return plannerManager;
	}

	public void savePlannerManager()
	{
		Utils.putObjectIntoSharedPreferences("plannerManagerWeek", this.week);
	}
	
	
	
	public ArrayList<ArrayList<Boolean>> getWeek() {
		return getPlannerManager().week;
	}

	public void setWeek(ArrayList<ArrayList<Boolean>> week) {
		getPlannerManager().week = week;
	}

}
