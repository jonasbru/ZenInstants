package com.majomi.zeninstants.messages;

public class MesText extends Message {
	
	private String text;
	private String imageSrc;
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the imageSrc
	 */
	public String getImageSrc() {
		return imageSrc;
	}
	/**
	 * @param imageSrc the imageSrc to set
	 */
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	
	/**
	 * Null Constructor
	 */
	public MesText()
	{
		this.setType(Message_Type.TEXT);
	}
	/**
	 * Constructor of text message without photo
	 * @param txt (Text of the message)
	 */
	public MesText(String txt)
	{
		this.setType(Message_Type.TEXT);
		this.text = txt;
	}
	
	/**
	 * Constructor
	 * @param txt ( Text of the message)
	 * @param imgSrc (Image of the message)
	 */
	public MesText(String txt, String imgSrc)
	{
		this.setType(Message_Type.TEXT);
		this.text = txt;
		this.imageSrc = imgSrc;
	}
	public String[] showToHistorial() {
		// TODO Auto-generated method stub
		String[] a = {this.text};
		return a;
	}
	public Message getMessage() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public String[] textToHistorial(int i)
	{
		String[] ret = {this.text};
		return ret;
	}
	
	

}
