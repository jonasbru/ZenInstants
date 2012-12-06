package com.majomi.zeninstants.messagesviews;

import com.majomi.zeninstants.R;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MessageSoundView extends MessageView {

	
	public MessageSoundView(String sound, String text){
		msg = new MessageVideoEntity(sound, text);
	}
	
	@Override
	public int getHistoricalLayout() {
		// TODO Auto-generated method stub
		return R.layout.historial_message_sound;
	}

	@Override
	public View createHistorialView(Activity act) {
		View vi = inflateView(act);
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_audio_text);
		summarytext.setText(msg.getSummary());
		return vi;
	}

	@Override
	public void fillMessageView(Activity act) {
		// TODO Auto-generated method stub
		
	}

}
