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

import com.majomi.zeninstants.messagesentities.MessageTextEntity;


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
	}
	//******** END Singleton ***********
	
	private ArrayList<MessageTextEntity> messages = new ArrayList<MessageTextEntity>();
	private SharedPreferences sp;
	
	public void addMessage(MessageTextEntity message) {
		this.messages.add((MessageTextEntity)message.clone());
		
		SharedPreferences.Editor editor = this.sp.edit();

		String s = serializeObject(this.messages);

		if(this.sp.contains("historial_messages")) {
			editor.remove("historial_messages"); 
		}
		
		editor.putString("historial_messages", s);

		editor.commit();
	}
	
	public MessageTextEntity getMessage(int index) {
		return this.messages.get(index);
	}

	@SuppressWarnings("unchecked")
	public void loadMessages(SharedPreferences sp) {
		this.sp = sp;
		
		this.messages = (ArrayList<MessageTextEntity>) deserializeObject(this.sp.getString("historial_messages", ""));
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
