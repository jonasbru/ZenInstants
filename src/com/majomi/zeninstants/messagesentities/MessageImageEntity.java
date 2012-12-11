package com.majomi.zeninstants.messagesentities;

import com.majomi.zeninstants.utils.Utils;


public class MessageImageEntity extends MessageTextEntity {
	private static final long serialVersionUID = 1563615056350174968L;
	
	private String imageURL;
	private String localImage;
		
	public MessageImageEntity(String txt, String imageURL) {
		super();
		this.setImageURL(imageURL);
		String local = Utils.saveDataFromURL(imageURL);
		if (local == null)
			this.localImage = "";
		else
			this.localImage = local;
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
