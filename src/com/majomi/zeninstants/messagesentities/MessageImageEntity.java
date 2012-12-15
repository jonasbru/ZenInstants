package com.majomi.zeninstants.messagesentities;



public class MessageImageEntity extends MessageTextEntity {
	private static final long serialVersionUID = 1563615056350174968L;
	
	private String imageURL;
	
	private String localImage = "plop";
	public MessageImageEntity(){
		localImage = "plop";
	}
	
	public MessageImageEntity(String txt, String imageURL) {
		super();
		setImageURL(imageURL);
		setLocalImage("localImage");
		setText(txt);
		setSummary(txt);
	}
	
	public MessageImageEntity(String txt,  String imageURL, String localImage) {
		super();
		setImageURL(imageURL);
		setLocalImage(localImage);
		setText(txt);
		setSummary(txt);
	}
	
	public String getLocalImage() {
		return localImage;
	}

	public void setLocalImage(String image) {
		this.localImage = image;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String uRLImage) {
		imageURL = uRLImage;
	}
	
}
