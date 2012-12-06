package com.majomi.zeninstants.messagesentities;


public class MessageImageEntity extends MessageTextEntity {
	private String image; //src image
	private int imageResource; 
		
	public MessageImageEntity(String image, String txt) {
		super();
		this.image = image;
		setText(txt);
		setSummary(txt);
	}

	public MessageImageEntity(int img)
	{
		super();
		this.setImageResource(img);	
	}
	
	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
