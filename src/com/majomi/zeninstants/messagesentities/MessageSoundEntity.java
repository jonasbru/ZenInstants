package com.majomi.zeninstants.messagesentities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.majomi.zeninstants.R;

public class MessageSoundEntity extends MessageEntity implements MessageInterface{
	String sound;

	public MessageSoundEntity(String sound, String txt) {
		super();
		this.sound = sound;
		setSummary(txt);
		setText(txt);		
	}
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
	public int getLayout()
	{
		return R.layout.historial_message_sound;
	}
	
	public void setHistorialContent(Activity act, View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_audio_text);
		summarytext.setText(getSummary());
	}
	
	public void onItemSelected(Context cxt)
	{
		Toast.makeText(cxt, "Sound!", Toast.LENGTH_LONG).show();
	}
}
