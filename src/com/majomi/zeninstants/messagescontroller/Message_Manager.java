package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.messagesviews.MessageImageView;
import com.majomi.zeninstants.messagesviews.MessageSoundView;
import com.majomi.zeninstants.messagesviews.MessageTextView;
import com.majomi.zeninstants.messagesviews.MessageVideoView;
import com.majomi.zeninstants.messagesviews.MessageView;

/**
 * 
 * Manage sets of messages
 * Singleton
 *
 */
public class Message_Manager {

	private ArrayList<MessageView> messages;
	static private Message_Manager messageManager = null;
	
	public ArrayList <MessageView> getMessages()
	{
		return messages;
	}
	
	public Message_Manager()
	{
		messages = new ArrayList<MessageView>();
		messages.add(new MessageTextView("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageView("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageVideoView("video", "letras random sin significado aparente"));
	 	messages.add(new MessageSoundView("elem1", "elem2"));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis diam eu sem bibendum venenatis"));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
	}
	
	/**
	 * Default constructor with some values ( i > 3 )
	 */
	public Message_Manager(int i)
	{
		messages = new ArrayList<MessageView>();
		messages.add(new MessageTextView("Ut at magna vel urna dapibus vestibulum at quis lorem."));
		messages.add(new MessageImageView("drawable/templo_cerezo", "Templo con cerezos"));
		messages.add(new MessageVideoView("video", "letras random sin significado aparente"));	
	 	messages.add(new MessageSoundView("elem1", "elem2"));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis diam eu sem bibendum venenatis"));
		messages.add(new MessageTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
		for(int j = 0; j < i ; j++)
		{
			messages.add(new MessageTextView("Something"));
		}
	}
	
	/**
	 * Set messages like mm
	 * @param mm (Message_Manager)
	 */
	public Message_Manager(ArrayList <MessageView> mm)
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
	
	public MessageView getMessageView(int i){
		return messages.get(i);
	}
	
	
}
