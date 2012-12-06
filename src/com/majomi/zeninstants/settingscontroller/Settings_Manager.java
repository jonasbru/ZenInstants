package com.majomi.zeninstants.settingscontroller;


public class Settings_Manager {
		
	static private Settings_Manager settingsManager = null;
	
	private boolean notifications_enabled;
	private boolean text_enabled;
	private boolean photo_enabled;
	private boolean music_enabled;
	private boolean video_enabled;

	private Settings_Manager()
	{
		this.setNotifications_enabled(true);
		this.setText_enabled(true);
		this.setPhoto_enabled(true);
		this.setMusic_enabled(true);
		this.setVideo_enabled(true);
	}
	
	/**
	 * Singleton method
	 * @return Settings_Manager
	 */
	static public Settings_Manager getSettingsManager()
	{
		if(settingsManager == null) settingsManager = new Settings_Manager();
		return settingsManager;
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
		
	
	

	

}
