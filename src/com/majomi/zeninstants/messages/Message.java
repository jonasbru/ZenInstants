package com.majomi.zeninstants.messages;


/**
 * 
 * Differents kinds of messages the app can receive
 *
 */
public class Message implements Message_Interface {

	private Message_Type type;
	
	/**
	 * 
	 * @param t Message_Type
	 */
	public void setType(Message_Type t)
	{
		this.type = t;
	}
	
	/**
	 * 
	 * @return Message_Type
	 */
	public Message_Type getType()
	{
		return this.type;
	}
	
	public void showToHistorial() {
		// TODO Auto-generated method stub
		if (this.type == Message_Type.TEXT)
		{
			//DO SOMETHING
		}
		if (this.type == Message_Type.PHOTO)
		{
			//DO SOMETHING
		}
	}	
	
	public Message getMessage() {
		// TODO Auto-generated method stub
		return this;
	}

}
