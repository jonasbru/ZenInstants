package com.majomi.zeninstants.messagesviews;

import com.majomi.zeninstants.R;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MessageVideoView extends MessageView{
	
	public MessageVideoView(String video, String text){
		msg = new MessageVideoEntity(video, text);
	}
	@Override
	public View createHistorialView(Activity act) {
		View vi = inflateView(act);
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_video_text);
		summarytext.setText(msg.getSummary());
		return vi;
	}

	@Override
	protected int getHistoricalLayout() {
		// TODO Auto-generated method stub
		return R.layout.historial_message_video;
	}

	@Override
	public void fillMessageView(Activity act) {
		// TODO Auto-generated method stub
		
	}

}
