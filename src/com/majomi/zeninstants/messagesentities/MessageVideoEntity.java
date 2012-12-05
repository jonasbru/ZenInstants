package com.majomi.zeninstants.messagesentities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.majomi.zeninstants.R;

public class MessageVideoEntity extends MessageEntity implements MessageInterface{
	String video;

	public MessageVideoEntity(String video, String txt) {
		this.video = video;
		setText(txt);
		setSummary(txt);
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	public int getLayout()
	{
		return R.layout.historial_message_video;
	}
	
	public void setHistorialContent(Activity act, View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_video_text);
		summarytext.setText(getSummary());
	}
	
	public void onItemSelected(Context cxt)
	{
		Toast.makeText(cxt, "Video!", Toast.LENGTH_LONG).show();
	}
}
