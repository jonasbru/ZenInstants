package com.majomi.zeninstants.messagesentities;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.majomi.zeninstants.R;

public class MessageImageEntity extends MessageEntity implements MessageInterface {
	private String image; //src image to drawable component
	private int imageResource; 
		
	public MessageImageEntity(String image, String txt) {
		super();
		this.image = image;
		setText(txt);
		setSummary(txt);
	}

	public MessageImageEntity(int img)
	{
		super();
		this.setImageResource(img);	
	}
	
	public int getImageResource() {
		return imageResource;
	}

	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getLayout()
	{
		return R.layout.historial_message_image_and_text;
	}
	
	public void setHistorialContent(Activity act, View vi)
	{
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_image_text);
		summarytext.setText(getSummary());
		
		this.imageResource = act.getResources().getIdentifier(
				this.image, null, act.getPackageName());
		
		ImageView image = (ImageView) vi.findViewById(R.id.historial_image);
		image.setImageDrawable(act.getResources().getDrawable(imageResource));
	}

	public void onItemSelected(Context cxt)
	{
		Toast.makeText(cxt, "Image!", Toast.LENGTH_LONG).show();
	}
}
