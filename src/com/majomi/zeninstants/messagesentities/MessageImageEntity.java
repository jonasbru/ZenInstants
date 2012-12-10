package com.majomi.zeninstants.messagesentities;


public class MessageImageEntity extends MessageTextEntity {
	private String image; 
		
	public MessageImageEntity(String image, String txt) {
		super();
		this.image = image;
		setText(txt);
		setSummary(txt);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
