package com.majomi.zeninstants;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MessageButtonHandler {
	Activity activity;
	ImageButton cancel;
	ImageButton favorite;
	Button info;
	
	protected Boolean favoriteActivated = false;
	
	public MessageButtonHandler(Activity act){
		activity = act;
		
		favorite = (ImageButton) act.findViewById(R.id.message_favorite_btn);
		info = (Button) act.findViewById(R.id.message_info_btn);
		cancel = (ImageButton) act.findViewById(R.id.message_cancel);
		
		favorite.setOnClickListener(favoriteListener);
		info.setOnClickListener(infoListener);
		cancel.setOnClickListener(cancelListener);	
	}
	
	private OnClickListener infoListener = new OnClickListener() {
	    @Override
		public void onClick(View v) {
	    	//TODO
	    }
	};
	
	private OnClickListener cancelListener = new OnClickListener() {
	    @Override
		public void onClick(View v) {
	    	activity.finish();
	    }
	};
	
	private OnClickListener favoriteListener = new OnClickListener() {
	    @Override
		public void onClick(View v) {
	    	if(!favoriteActivated){
	    		favorite.setImageResource(R.drawable.rating_favorite_red);
	    	}else{
	    		favorite.setImageResource(R.drawable.rating_favorite);
	    	}
	    	favoriteActivated = !favoriteActivated;
	    }

	};
}
