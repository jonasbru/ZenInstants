package com.majomi.zeninstants.messages;

import java.util.ArrayList;


/**
 * 
 * Manage sets of messages
 *
 */
public class Message_Manager {

	private ArrayList <Message> messages;
	
	/**
	 * Default constructor
	 */
	public Message_Manager()
	{
		messages = new ArrayList<Message>();
	}
	
	/**
	 * Set messages like mm
	 * @param mm (Message_Manager)
	 */
	public Message_Manager(ArrayList <Message> mm)
	{
		this.messages = mm;
	}
	
	
}
