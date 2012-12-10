package com.majomi.zeninstants.settingscontroller;

import java.util.ArrayList;
import java.util.Random;

public class Planner_Manager {

	static private Planner_Manager plannerManager = null;
	
	private ArrayList<ArrayList<Boolean>> week = new ArrayList<ArrayList <Boolean>>();

	public Planner_Manager()
	{
		for(int i = 0; i < 7; i++)
		{
			Random r = new Random();
			week.add(new ArrayList <Boolean>());
			for(int j = 0; j < 24; j++)
			{
				if(r.nextFloat() < 0.5 )
				{
					week.get(i).add(false);
				}
				else
				{
					week.get(i).add(true);
				}
			}
		}
		
	}
	
	static public Planner_Manager getPlannerManager()
	{
		if(plannerManager == null) plannerManager = new Planner_Manager();
		return plannerManager;
	}

	public ArrayList<ArrayList<Boolean>> getWeek() {
		return getPlannerManager().week;
	}

	public void setWeek(ArrayList<ArrayList<Boolean>> week) {
		getPlannerManager().week = week;
	}

}
