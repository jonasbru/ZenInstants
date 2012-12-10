package com.majomi.zeninstants;

import android.util.Log;

public class AppLog {
	public static final String LOG = "ZEN";
	public static final String WARNING = "ZEN_Warnning";
	
	public static int logString(String message){
		return Log.i(LOG,message);
	}
	public static int logString(String message, String tag){
		return Log.i(tag,message);
	}
	public static int logWarningString(String message){
		return Log.i(WARNING,message);
	}
}