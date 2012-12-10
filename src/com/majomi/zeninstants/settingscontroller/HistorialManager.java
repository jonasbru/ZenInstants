package com.majomi.zeninstants.settingscontroller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;


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
	private SharedPreferences sp;

	public void addMessage(MessageTextEntity message) {
		this.messages.add((MessageTextEntity)message.clone());

		save();
	}

	public MessageTextEntity getMessage(int index) {
		return this.messages.get(this.messages.size() - 1 - index);
	}

	@SuppressWarnings("unchecked")
	public void loadMessages(SharedPreferences sp) {
		this.sp = sp;

		if(this.sp.contains("historial_messages")) {
			Object res = deserializeObject(this.sp.getString("historial_messages", ""));

			if(res != null) {
				this.messages = (ArrayList<MessageTextEntity>) res;
			}
		}
	}

	public int getMessagesSize() {
		return this.messages.size();
	}

	private void save() {

		SharedPreferences.Editor editor = this.sp.edit();

		String s = serializeObject(this.messages);

		if(this.sp.contains("historial_messages")) {
			editor.remove("historial_messages"); 
		}

		editor.putString("historial_messages", s);

		editor.commit();		
	}

	/**
	 * Help function to serialize an object into a string
	 * @param o
	 * @return
	 */
	private static String serializeObject(Object o) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			ObjectOutput out = new ObjectOutputStream(bos);
			out.writeObject(o);
			out.close();

			// Get the bytes of the serialized object
			byte[] buf = bos.toByteArray();

			return Base64.encodeToString(buf, Base64.DEFAULT);
		} catch (IOException ioe) {
			Log.e("serializeObject", "error", ioe);

			return null;
		}
	}

	/**
	 * Help function to deserialize an object from a string
	 * @param b
	 * @return
	 */
	private static Object deserializeObject(String b) {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(Base64.decode(b, Base64.DEFAULT)));
			Object object = in.readObject();
			in.close();

			return object;
		} catch (ClassNotFoundException cnfe) {
			Log.e("deserializeObject", "class not found error", cnfe);

			return null;
		} catch (IOException ioe) {
			Log.e("deserializeObject", "io error", ioe);

			return null;
		}
	}

}
