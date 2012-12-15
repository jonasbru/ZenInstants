package com.majomi.zeninstants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MessagesServiceStarter extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent startServiceIntent = new Intent(context, MessagesService.class);
		context.startService(startServiceIntent);
	}

}
