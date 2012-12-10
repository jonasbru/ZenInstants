package com.majomi.zeninstants;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.HistorialViewsManager;
import com.majomi.zeninstants.settingscontroller.HistorialManager;

public class HistorialAdapter extends BaseAdapter {
	protected Activity activity;

	public HistorialAdapter(Activity activity) {
		this.activity = activity;
	}

	public int getCount() {
//		return MessageManager.getMessageManager().getSize();
		return HistorialManager.getHistorialManager().getMessagesSize();
	}


	public Object getItem(int position) {
		//return MessageManager.getMessageManager().get(position);
		return HistorialManager.getHistorialManager().getMessage(position);		
	}

	public long getItemId(int position) {
		//return MessageManager.getMessageManager().get(position).getId();
		return HistorialManager.getHistorialManager().getMessage(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		//TODO use convertView for preformences
		//MessageTextEntity message = MessageManager.getMessageManager().get(position);
		MessageTextEntity message = HistorialManager.getHistorialManager().getMessage(position);
		View vi = HistorialViewsManager.getHistorialViewsManager().createHistorialView(message, activity);

		return vi;
	}

}