package com.majomi.zeninstants.messagesentities;

public class MessageVideoEntity extends MessageTextEntity {
	String video;

	public MessageVideoEntity(String video) {
		this.video = video;
	}
	
	public MessageVideoEntity(String text, String video) {
		super(text);
		this.video = video;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
}
