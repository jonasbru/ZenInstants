package com.majomi.zeninstants.messagesviews;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


public abstract class MessageView {
	protected MessageTextEntity msg;
	
	public abstract View createHistorialView(Activity act);
	public abstract void fillMessageView(Activity act);
	public long getId(){
		return msg.getId();
	}
	
	protected abstract int getHistoricalLayout();
	protected View inflateView(Activity act){
		LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vi = inflater.inflate(getHistoricalLayout(), null);
		return vi;
	}
	
}
