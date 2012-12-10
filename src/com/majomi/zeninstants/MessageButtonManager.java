package com.majomi.zeninstants;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockActivity;

public class MessageButtonManager {
	SherlockActivity activity;
	ImageButton cancel;
	ImageButton favorite;
	Button info;
	
	protected Boolean favoriteActivated = false;
	
	public MessageButtonManager(SherlockActivity act){
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
	    	goToUrl ("http://www.youtube.com/watch?v=oavMtUWDBTM");
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
	
	private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        activity.startActivity(launchBrowser);
    }
}
