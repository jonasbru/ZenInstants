package com.majomi.zeninstants.messagesentities;

public class MessageVideoEntity extends MessageTextEntity {
	private static final long serialVersionUID = 7934522068978592593L;
	
	String video = "plop";

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
