package com.majomi.zeninstants.messagesentities;

public class MessageVideoEntity extends MessageTextEntity implements Message{
	String video;

	public MessageVideoEntity(String video) {
		this.video = video;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
}
