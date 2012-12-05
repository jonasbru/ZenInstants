package com.majomi.zeninstants.messagesentities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
	
	public void setHistorialContent(Activity act, View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.hmtext);
		summarytext.setText(getSummary());
	}
	
	public void onItemSelected(Context cxt)
	{
		Toast.makeText(cxt, "Text!", Toast.LENGTH_LONG).show();
	}
	
}
