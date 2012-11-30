package com.majomi.zeninstants.messagesentities;

public class MessageImageEntity extends MessageTextEntity implements Message {
	String image;
	
	public MessageImageEntity(String image) {
		super();
		this.image = image;
	}
	
	public MessageImageEntity(String image, String text) {
		super(text);
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
