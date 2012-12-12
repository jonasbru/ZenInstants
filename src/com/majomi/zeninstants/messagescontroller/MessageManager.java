package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;
import java.util.List;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.utils.Utils;

public class MessageManager {

	//********** Singleton *************
	static private MessageManager messageManager = null;

	static public MessageManager getMessageManager() {
		if(messageManager == null) {
			messageManager = new MessageManager();
		}	
		return messageManager;
	}

	private MessageManager() {	
	}
	//******** END Singleton ***********
	
	
	private ArrayList<MessageTextEntity> messages = new ArrayList<MessageTextEntity>();

	public int getSize() {
		return messages.size();
	}

	public MessageTextEntity get(int i) {
		return messages.get(i);
	}

	public void replaceMessages(List <MessageTextEntity> messages) {
		this.messages.clear();
		this.messages.addAll(messages);
		
		Utils.putObjectIntoSharedPreferences("messages", this.messages);
	}
	
	@SuppressWarnings("unchecked")
	public List<MessageTextEntity> getMessagesCloned() {
		return (List<MessageTextEntity>) this.messages.clone();
	}
	
	public void popRandomMessage() {
		if(!this.messages.isEmpty()) {
			
		}
	}


}
