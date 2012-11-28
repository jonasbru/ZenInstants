package com.majomi.zeninstants.messages;


public interface Message_Interface {

	/**
	 * Show the message to historial
	 */
	public abstract String[] showToHistorial();

	/**
	 *  Retrieves current Message
	 * @return Message
	 */
	public Message getMessage();
	
	

}
