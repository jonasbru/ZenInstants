package com.majomi.zeninstants.messagesentities;

public class MessageImageEntity extends MessageEntity implements MessageInterface {
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
