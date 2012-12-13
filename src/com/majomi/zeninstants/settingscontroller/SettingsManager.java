package com.majomi.zeninstants.settingscontroller;


public class SettingsManager {
		
	static private SettingsManager settingsManager = null;
	
	private boolean notificationsEnabled = true;
	
	private boolean textEnabled = true;
	private boolean photoEnabled = true;
	private boolean musicEnabled = true;
	private boolean videoEnabled = true;
	
	private int notificationsPerDay = 3;

	private SettingsManager() {
		
	}
	
	/**
	 * Singleton method
	 * @return Settings_Manager
	 */
	static public SettingsManager getSettingsManager() {
		if(settingsManager == null){
			settingsManager = new SettingsManager();
		}
		return settingsManager;
	}
	
	
	
	public boolean isNotificationsEnabled() {
		return notificationsEnabled;
	}

	public void setNotificationsEnabled(boolean notificationsEnabled) {
		this.notificationsEnabled = notificationsEnabled;
	}

	public boolean isTextEnabled() {
		return textEnabled;
	}

	public void setTextEnabled(boolean textEnabled) {
		this.textEnabled = textEnabled;
	}

	public boolean isPhotoEnabled() {
		return photoEnabled;
	}

	public void setPhotoEnabled(boolean photoEnabled) {
		this.photoEnabled = photoEnabled;
	}

	public boolean isMusicEnabled() {
		return musicEnabled;
	}

	public void setMusicEnabled(boolean musicEnabled) {
		this.musicEnabled = musicEnabled;
	}

	public boolean isVideoEnabled() {
		return videoEnabled;
	}

	public void setVideoEnabled(boolean videoEnabled) {
		this.videoEnabled = videoEnabled;
	}

	public int getNotificationsPerDay() {
		return notificationsPerDay;
	}

	public void setNotificationsPerDay(int notificationsPerDay) {
		this.notificationsPerDay = notificationsPerDay;
	}
	
	
}
