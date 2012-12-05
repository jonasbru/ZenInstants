package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageEntity;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;

/**
 * 
 * Manage sets of messages
 * Singleton
 *
 */
public class Message_Manager {

	private ArrayList<MessageEntity> messages;
	static private Message_Manager messageManager = null;
	
	public ArrayList <MessageEntity> getMessages()
	{
		return messages;
	}
	
	public Message_Manager()
	{
		messages = new ArrayList<MessageEntity>();
		messages.add(new MessageTextEntity("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageEntity("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageTextEntity("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis diam eu sem bibendum venenatis"));
		messages.add(new MessageTextEntity("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
	}
	
	/**
	 * Default constructor with some values ( i > 3 )
	 */
	public Message_Manager(int i)
	{
		messages = new ArrayList<MessageEntity>();
		messages.add(new MessageTextEntity("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageEntity("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageTextEntity("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis diam eu sem bibendum venenatis"));
		messages.add(new MessageTextEntity("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
		for(int j = 0; j < i ; j++)
		{
			messages.add(new MessageTextEntity("Something"));
		}
	}
	
	/**
	 * Set messages like mm
	 * @param mm (Message_Manager)
	 */
	public Message_Manager(ArrayList <MessageEntity> mm)
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
	
	public MessageEntity getMessage(int i){
		return messages.get(i);
	}
	
	public String getSummary(int i)
	{
		return (messages.get(i)).getSummary();
	}

	
	
}
