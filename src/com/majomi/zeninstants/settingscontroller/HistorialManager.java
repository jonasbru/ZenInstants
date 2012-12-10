package com.majomi.zeninstants.settingscontroller;

import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
import com.majomi.zeninstants.utils.Utils;


public class HistorialManager {

	//********** Singleton *************
	static private HistorialManager historialManager = null;

	static public HistorialManager getHistorialManager() {
		if(historialManager == null) {
			historialManager = new HistorialManager();
		}	
		return historialManager;
	}

	private HistorialManager() {
		//TODO remove all that stuff later..
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));
		this.messages.add(new MessageVideoEntity("LONG TEXT HERE\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.", "TODO"));
		this.messages.add(new MessageSoundEntity("LONG TEXT HERE\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.", "TODO"));
		this.messages.add(new MessageImageEntity("LONG TEXT HERE\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.", "TODO"));
		this.messages.add(new MessageTextEntity("LONG TEXT HERE\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque auctor enim eget sem pulvinar pretium. Donec suscipit consequat mi id commodo. Vestibulum semper volutpat odio, id luctus sapien malesuada eget. Quisque semper leo quis urna rhoncus at euismod orci malesuada. Quisque tortor arcu, condimentum vel cursus eu, consequat sit amet ante. Vestibulum sodales tincidunt urna, sit amet interdum diam sodales vitae. Curabitur ac enim erat. Quisque rhoncus venenatis orci, vitae ultricies arcu fermentum blandit. Aliquam malesuada ornare varius. Integer lobortis tempus porttitor. Aenean libero enim, adipiscing in pharetra eget, pellentesque eu nibh. Pellentesque eleifend faucibus suscipit. Maecenas ornare imperdiet bibendum."));
		this.messages.add(new MessageVideoEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah", "TODO"));
		this.messages.add(new MessageSoundEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah", "TODO"));
		this.messages.add(new MessageImageEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah", "TODO"));
		this.messages.add(new MessageTextEntity("Roses are red\nViolets are blue\nThis is the first phrase\nYeah yeah youpi yeah"));


	}
	//******** END Singleton ***********

	private ArrayList<MessageTextEntity> messages = new ArrayList<MessageTextEntity>();

	public void addMessage(MessageTextEntity message) {
		this.messages.add((MessageTextEntity)message.clone());

		save();
	}

	public MessageTextEntity getMessage(int index) {
		return this.messages.get(this.messages.size() - 1 - index);
	}

	@SuppressWarnings("unchecked")
	public void loadMessages() {
		Object res = Utils.getObjectFromSharedPreferences("historial_messages");

		if(res != null) {
			this.messages = (ArrayList<MessageTextEntity>) res;
		}
	}

	public int getMessagesSize() {
		return this.messages.size();
	}

	private void save() {
		Utils.putObjectIntoSharedPreferences("historial_messages", this.messages);	
	}

}
