package com.majomi.zeninstants.settingscontroller;

import com.majomi.zeninstants.utils.Utils;



public class SettingsManager {
		
	static private SettingsManager settingsManager = null;

	private boolean notifications_enabled;
	private boolean text_enabled;
	private boolean photo_enabled;
	private boolean music_enabled;
	private boolean video_enabled;
	
	private int notificationsPerDay;
	private int stressLevel;

	
	private SettingsManager()
	{
		try
		{
			this.notifications_enabled = (Boolean) Utils.getObjectFromSharedPreferences("settingsNotificationsEnabled");
			this.text_enabled = (Boolean) Utils.getObjectFromSharedPreferences("settingsTextEnabled");
			this.photo_enabled = (Boolean) Utils.getObjectFromSharedPreferences("settingsPhotoEnabled");
			this.music_enabled = (Boolean) Utils.getObjectFromSharedPreferences("settingsPhotoEnabled");
			this.video_enabled = (Boolean) Utils.getObjectFromSharedPreferences("settingsVideoEnabled");
			this.notificationsPerDay = Utils.getIntFromSharedPreferences("settingsNotificationsPerDay", -1);
		    this.stressLevel = Utils.getIntFromSharedPreferences("settingsStressLevel",-1);
		}
		catch (Exception e) {
			this.setNotifications_enabled(true);
			this.setText_enabled(true);
			this.setPhoto_enabled(true);
			this.setMusic_enabled(true);
			this.setVideo_enabled(true);
			this.setStressLevel(0);
			this.setNotificationsPerDayStressLevel();
		}
	}
	
	/**
	 * Singleton method
	 * @return Settings_Manager
	 */
	static public SettingsManager getSettingsManager()
	{
		if(settingsManager == null) settingsManager = new SettingsManager();
		return settingsManager;
	}

	public void saveSettings()
	{
		Utils.putObjectIntoSharedPreferences("settingsNotificationsEnabled", this.notifications_enabled);
		Utils.putObjectIntoSharedPreferences("settingsTextEnabled", this.text_enabled);
		Utils.putObjectIntoSharedPreferences("settingsPhotoEnabled", this.photo_enabled);
		Utils.putObjectIntoSharedPreferences("settingsMusicEnabled", this.music_enabled);
		Utils.putObjectIntoSharedPreferences("settingsVideoEnabled", this.video_enabled);
		Utils.putIntIntoSharedPreferences("settingsnotificationsPerDay", this.notificationsPerDay);
		Utils.putIntIntoSharedPreferences("settingsstressLevel", this.stressLevel);
	}
	
	public void setNotificationsPerDayStressLevel()
	{
		this.setNotificationsPerDay(this.stressLevel*2);
	}
	
	
	
	public boolean isNotifications_enabled() {
		return notifications_enabled;
	}

	public void setNotifications_enabled(boolean notifications_enabled) {
		this.notifications_enabled = notifications_enabled;
	}

	public boolean isText_enabled() {
		return text_enabled;
	}

	public void setText_enabled(boolean text_enabled) {
		this.text_enabled = text_enabled;
	}

	public boolean isPhoto_enabled() {
		return photo_enabled;
	}

	public void setPhoto_enabled(boolean image_enabled) {
		this.photo_enabled = image_enabled;
	}

	public boolean isMusic_enabled() {
		return music_enabled;
	}

	public void setMusic_enabled(boolean music_enabled) {
		this.music_enabled = music_enabled;
	}

	public boolean isVideo_enabled() {
		return video_enabled;
	}

	public void setVideo_enabled(boolean video_enabled) {
		this.video_enabled = video_enabled;
	}

	public int getNotificationsPerDay() {
		return notificationsPerDay;
	}

	public void setNotificationsPerDay(int notificationsPerDay) {
		this.notificationsPerDay = notificationsPerDay;
	}


	public int getStressLevel() {
		return stressLevel;
	}

	public void setStressLevel(int stressLevel) {
		this.stressLevel = stressLevel;
	}
}
