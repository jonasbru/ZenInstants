package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.settingscontroller.SettingsManager;
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
	
	@SuppressWarnings("rawtypes")
	public MessageTextEntity getMessage(long id, Class entityClass) {
		MessageTextEntity ret = null;
		
		for(MessageTextEntity m : this.messages) {
			if(m.getId() == id && m.getClass().equals(entityClass)) {
				ret = m;
				break;
			}
		}
		
		return ret;
	}
	
	public MessageTextEntity getRandomMessage() {
		@SuppressWarnings("unchecked")
		ArrayList<MessageTextEntity> msgs = (ArrayList<MessageTextEntity>) this.messages.clone();
		
		for (MessageTextEntity mte : this.messages) {
			if((!SettingsManager.getSettingsManager().isPhotoEnabled()) && mte instanceof MessageImageEntity
					|| (!SettingsManager.getSettingsManager().isMusicEnabled()) && mte instanceof MessageSoundEntity
					|| (!SettingsManager.getSettingsManager().isVideoEnabled()) && mte instanceof MessageVideoEntity
					|| (!SettingsManager.getSettingsManager().isTextEnabled())) {
				msgs.remove(mte);
			}
		}

		int random = (int)(Math.random() * msgs.size());
		
		if(!this.messages.isEmpty()) {
			return msgs.get(random);
		} else {
			return null;
		}
	}


}
