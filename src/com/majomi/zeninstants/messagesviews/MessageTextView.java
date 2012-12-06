package com.majomi.zeninstants.messagesviews;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.majomi.zeninstants.R;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;

public class MessageTextView extends MessageView {
	
	public MessageTextView(String text){
		msg = new MessageTextEntity(text);
	}
	
	public MessageTextView(String text,String summary){
		msg = new MessageTextEntity(text, summary);
	}
	
	@Override
	protected int getHistoricalLayout()
	{
		return R.layout.historial_message_text;
	}
	
	@Override
	public View createHistorialView(Activity act)
	{
		View vi = inflateView(act);
		TextView summarytext = (TextView) vi.findViewById(R.id.hmtext);
		summarytext.setText(msg.getSummary());
		return vi;
	}

	@Override
	public void fillMessageView(Activity act) {
        TextView text = (TextView) act.findViewById(R.id.Message_Text);
        text.setText(msg.getText());	
	}
}
