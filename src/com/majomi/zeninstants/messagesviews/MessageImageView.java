package com.majomi.zeninstants.messagesviews;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.majomi.zeninstants.R;
import com.majomi.zeninstants.messagesentities.MessageImageEntity;

public class MessageImageView extends MessageView {
	
	public MessageImageView(String image, String txt){
		msg = new MessageImageEntity(image, txt);
	}
	
	@Override
	public int getHistoricalLayout()
	{
		return R.layout.historial_message_image_and_text;
	}
	
	@Override
	public View createHistorialView(Activity act)
	{

		View vi = inflateView(act);
		TextView summarytext = (TextView) vi.findViewById(R.id.historial_image_text);
		summarytext.setText(msg.getSummary());
		
		int imageResource = act.getResources().getIdentifier(
				((MessageImageEntity)msg).getImage(), null, act.getPackageName());
		
		ImageView image = (ImageView) vi.findViewById(R.id.historial_image);
		image.setImageDrawable(act.getResources().getDrawable(imageResource));
		
		return vi;
	}

	@Override
	public void fillMessageView(Activity act) {
		// TODO Auto-generated method stub
		
	}
}
