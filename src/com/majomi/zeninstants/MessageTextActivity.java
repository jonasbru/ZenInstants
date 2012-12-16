package com.majomi.zeninstants;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.utils.Utils;

public class MessageTextActivity extends SherlockActivity {
	
	private MessageTextEntity entity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_message_text);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		
		//entity = (MessageTextEntity) getIntent().getExtras().getSerializable("MESSAGE");		
		
		entity = Utils.getOriginalEntity(getIntent().getExtras().getString("msg_from"), getIntent().getExtras().getLong("msg_id"), getIntent().getExtras().getString("msg_type"));
		
		fillView();
		
		new MessageButtonManager(this, entity);
	}

	public void fillView(){
		TextView text = (TextView) this.findViewById(R.id.message_text);
		text.setText(entity.getText());
		
		ImageButton favorite = (ImageButton) this.findViewById(R.id.message_favorite_btn);
		if(entity.isFavorite()) {
			favorite.setImageResource(R.drawable.rating_favorite_red);
		} else {
			favorite.setImageResource(R.drawable.rating_favorite);			
		}
	}
}
