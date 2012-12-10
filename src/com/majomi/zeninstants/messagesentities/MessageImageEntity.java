package com.majomi.zeninstants.messagesentities;


public class MessageImageEntity extends MessageTextEntity {
	private static final long serialVersionUID = 1563615056350174968L;
	
	private String image; 
		
	public MessageImageEntity(String txt, String image) {
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
