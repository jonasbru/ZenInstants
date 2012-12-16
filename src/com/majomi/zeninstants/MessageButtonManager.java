package com.majomi.zeninstants;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.settingscontroller.FavoritesManager;
import com.majomi.zeninstants.settingscontroller.HistorialManager;

public class MessageButtonManager {
	SherlockActivity activity;
	ImageButton cancel;
	ImageButton favorite;
	Button info;

	MessageTextEntity entity;

	protected Boolean favoriteActivated = false;

	public MessageButtonManager(SherlockActivity act, MessageTextEntity entity){
		this.activity = act;
		this.entity = entity;

		this.favorite = (ImageButton) act.findViewById(R.id.message_favorite_btn);
		this.info = (Button) act.findViewById(R.id.message_info_btn);
		this.cancel = (ImageButton) act.findViewById(R.id.message_cancel);

		this.favorite.setOnClickListener(this.favoriteListener);
		this.info.setOnClickListener(this.infoListener);
		this.cancel.setOnClickListener(this.cancelListener);	
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
			if(!entity.isFavorite()){
				favorite.setImageResource(R.drawable.rating_favorite_red);
				FavoritesManager.getFavoritesManager().addFavorite(entity);
			}else{
				favorite.setImageResource(R.drawable.rating_favorite);
				FavoritesManager.getFavoritesManager().removeFavorite(entity);
			}

			HistorialManager.getHistorialManager().saveMessages();
		}
	};

	private void goToUrl (String url) {
		Uri uriUrl = Uri.parse(url);
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
		activity.startActivity(launchBrowser);
	}
}
