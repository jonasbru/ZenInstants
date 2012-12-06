package com.majomi.zeninstants.settingscontroller;

public class Planner_Manager {

	static private Planner_Manager plannerManager = null;

	private boolean bullshit;
	
	public Planner_Manager()
	{
			
	}
	
	static public Planner_Manager getSettingsManager()
	{
		if(plannerManager == null) plannerManager = new Planner_Manager();
		return plannerManager;
	}
}
