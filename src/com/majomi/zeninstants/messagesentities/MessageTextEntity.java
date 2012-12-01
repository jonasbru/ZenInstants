package com.majomi.zeninstants.messagesentities;

import android.view.View;
import android.widget.TextView;

import com.majomi.zeninstants.R;

public class MessageTextEntity extends MessageEntity implements MessageInterface{
	
	public MessageTextEntity()
	{
		super();
	}
	
	public MessageTextEntity(String a)
	{
		super(a);
	}
	
	public MessageTextEntity(String text, String summary) {
		super(text, summary);
	}
	
	public int getLayout()
	{
		return R.layout.historial_message_text;
	}
	
	public void setHistorialContent(View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.hmtext);
		summarytext.setText(getSummary());
	}
	
}
