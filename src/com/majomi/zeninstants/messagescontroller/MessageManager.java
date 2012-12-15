package com.majomi.zeninstants.messagescontroller;

import java.util.ArrayList;
import java.util.List;

import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.settingscontroller.HistorialManager;
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
	
	public void saveMessages() {
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
		
		HistorialManager hm = HistorialManager.getHistorialManager();
		SettingsManager sm = SettingsManager.getSettingsManager();
		
		for (MessageTextEntity mte : this.messages) {
			if((!sm.isPhotoEnabled()) && mte.getClass() == MessageImageEntity.class
					|| (!sm.isMusicEnabled()) && mte.getClass() == MessageSoundEntity.class
					|| (!sm.isVideoEnabled()) && mte.getClass() == MessageVideoEntity.class
					|| (!sm.isTextEnabled()) && mte.getClass() == MessageTextEntity.class
					|| (hm.contains(mte))) {
				msgs.remove(mte);
			}
		}
		
		if(!msgs.isEmpty()) {
			int random = (int)(Math.random() * msgs.size());
			return msgs.get(random);
		} else {
			return hm.getRandomMessage();
		}
	}


}
