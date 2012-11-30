package com.majomi.zeninstants.messagesentities;

public class MessageTextEntity implements Message{
	private String text;
	private String summary; // Text shown in historical

	public MessageTextEntity() {
		this.text = new String();
		this.summary = new String();
	}
	
	public MessageTextEntity(String text) {
		super();
		this.text = text;
		if(text.length()> 40)
			this.summary = text.substring(0, 40);
		else
			this.summary = text;
	}
	
	public MessageTextEntity(String text, String summary) {
		super();
		this.text = text;
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}
