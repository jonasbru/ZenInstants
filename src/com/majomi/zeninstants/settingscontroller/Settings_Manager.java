package com.majomi.zeninstants.settingscontroller;


public class Settings_Manager {
		
	static private Settings_Manager settingsManager = null;
	
	private boolean notifications_enabled;
	private boolean text_enabled;
	private boolean image_enabled;
	private boolean music_enabled;
	private boolean video_enabled;

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

	public boolean isImage_enabled() {
		return image_enabled;
	}

	public void setImage_enabled(boolean image_enabled) {
		this.image_enabled = image_enabled;
	}

	private boolean isMusic_enabled() {
		return music_enabled;
	}

	private void setMusic_enabled(boolean music_enabled) {
		this.music_enabled = music_enabled;
	}

	private boolean isVideo_enabled() {
		return video_enabled;
	}

	private void setVideo_enabled(boolean video_enabled) {
		this.video_enabled = video_enabled;
	}
		
	
	public Settings_Manager()
	{
		this.setNotifications_enabled(true);
		this.setText_enabled(true);
		this.setImage_enabled(true);
		this.setMusic_enabled(true);
		this.setVideo_enabled(true);
	}
	
	/**
	 * Singleton method
	 * @return Message_Manager
	 */
	static public Settings_Manager getSettingsManager()
	{
		if(settingsManager == null) settingsManager = new Settings_Manager();
		return settingsManager;
	}


	

}
