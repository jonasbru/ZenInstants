package com.majomi.zeninstants.messagesentities;

public class MessageSoundEntity extends MessageTextEntity {
	private static final long serialVersionUID = 7072104459234487700L;
	
	String sound;

	public MessageSoundEntity(String sound) {
		super();
		this.sound = sound;
	}

	public MessageSoundEntity(String text, String sound) {
		super(text);
		this.sound = sound;
	}
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}
