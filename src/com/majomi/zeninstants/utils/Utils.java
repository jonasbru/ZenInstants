package com.majomi.zeninstants.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.util.Log;

public class Utils {
	
	private static Context context = null;

	private static final String prefFileName = "ZenInstantsDef";

	/**
	 * Help function to serialize an object into a string
	 * @param o
	 * @return
	 */
	public static String serializeObject(Object o) {
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
	public static Object deserializeObject(String b) {
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
	
	public static boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null;
	}

	public static Context getContext() {
		return context;
	}

	public static void setContext(Context contextt) {
		context = contextt;
	}
	
	public static Object getObjectFromSharedPreferences(String key) {
		if(context.getSharedPreferences(prefFileName, 0).contains(key)) {
			return Utils.deserializeObject(context.getSharedPreferences(prefFileName, 0).getString(key, ""));
		} else {
			return null;
		}
	}
	
	public static void putObjectIntoSharedPreferences(String key, Object obj) {
		SharedPreferences.Editor editor = context.getSharedPreferences(prefFileName, 0).edit();

		String s = serializeObject(obj);

		if(context.getSharedPreferences(prefFileName, 0).contains(key)) {
			editor.remove(key); 
		}

		editor.putString(key, s);

		editor.commit();
	}
	
}
