package com.majomi.zeninstants.messagesentities;

import android.app.Activity;
import android.content.Context;
import android.view.View;


public interface MessageInterface {

	public int getLayout();
	
	public void setHistorialContent(Activity act, View vi);
	
	public void onItemSelected(Context cxt);
	
}
