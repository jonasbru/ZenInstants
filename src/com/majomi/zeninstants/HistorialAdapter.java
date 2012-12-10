package com.majomi.zeninstants;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.majomi.zeninstants.messagescontroller.MessageManager;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesviews.HistorialViewsManager;

public class HistorialAdapter extends BaseAdapter {
	protected Activity activity;

	public HistorialAdapter(Activity activity) {
		this.activity = activity;
	}

	public int getCount() {
		synchronized(MessageManager.getMessageManager()) {
			return MessageManager.getMessageManager().getSize();
		}
	}


	public Object getItem(int position) {
		return MessageManager.getMessageManager().get(position);
	}

	public long getItemId(int position) {
		return MessageManager.getMessageManager().get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		//TODO use convertView for preformences
		MessageTextEntity message = MessageManager.getMessageManager().get(position);
		View vi = HistorialViewsManager.getHistorialViewsManager().createHistorialView(message, activity);

		return vi;
	}

}