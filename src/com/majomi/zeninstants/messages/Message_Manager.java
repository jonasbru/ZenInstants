package com.majomi.zeninstants.messages;

import java.util.ArrayList;

/**
 * 
 * Manage sets of messages
 * Singleton
 *
 */
public class Message_Manager {

	private ArrayList <Message> messages;
	static private Message_Manager messageManager = null;
	
	public ArrayList <Message> getMessages()
	{
		return messages;
	}
	
	/**
	 * Default constructor with some values ( i > 3 )
	 */
	public Message_Manager(int i)
	{
		messages = new ArrayList<Message>();
		messages.add(new MesText("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MesText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis diam eu sem bibendum venenatis"));
		messages.add(new MesText("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
		for(int j = 0; j < i ; j++)
		{
			messages.add(new MesText("Something"));
		}
	}
	
	/**
	 * Set messages like mm
	 * @param mm (Message_Manager)
	 */
	public Message_Manager(ArrayList <Message> mm)
	{
		this.messages = mm;
	}
	
	/**
	 * Singleton method
	 * @return Message_Manager
	 */
	static public Message_Manager getMessageManager()
	{
		if(messageManager == null) messageManager = new Message_Manager(3);
		return messageManager;
	}
	
	public String[] textToHistorial(int i)
	{
		return messages.get(i).showToHistorial();
	}
	
	
}
