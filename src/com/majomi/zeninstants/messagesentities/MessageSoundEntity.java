package com.majomi.zeninstants.messagesentities;

public class MessageSoundEntity extends MessageTextEntity implements Message{
	String sound;

	public MessageSoundEntity(String sound) {
		super();
		this.sound = sound;
	}

	public MessageSoundEntity(String sound, String image) {
		super(image);
		this.sound = sound;
	}
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}
