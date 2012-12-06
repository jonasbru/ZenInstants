package com.majomi.zeninstants;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.majomi.zeninstants.messagescontroller.Message_Manager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.MessageView;

public class Historial_Adapter extends BaseAdapter {
	protected Activity activity;
		         
	public Historial_Adapter(Activity activity) {
		this.activity = activity;
	}
		 
	public int getCount() {
	    return Message_Manager.getMessageManager().getMessages().size();
	}
		 
	
	public Object getItem(int position) {
		return Message_Manager.getMessageManager().getMessageView(position);
	}

	public long getItemId(int position) {
		return Message_Manager.getMessageManager().getMessages().get(position).getId();
	}
			 
	
	public View getView(int position, View convertView, ViewGroup parent) {
		//TODO use convertView for preformences
		MessageView message = Message_Manager.getMessageManager().getMessageView(position);
		View vi = message.createHistorialView(activity);
		
		return vi;
	}

}