package com.majomi.zeninstants;

import android.util.Log;

public class AppLog {
	public static final String LOG = "ZEN";
	public static final String WARNING = "ZEN_Warnning";
	public static final String ERROR = "ZEN_ERROR";
	
	public static int logString(String message){
		return Log.d(LOG,message);
	}
	public static int logString(String message, String tag){
		return Log.d(tag,message);
	}
	public static int logWarningString(String message){
		return Log.d(WARNING,message);
	}
	public static int logError(String message){
		return Log.e(ERROR,message);
	}
}