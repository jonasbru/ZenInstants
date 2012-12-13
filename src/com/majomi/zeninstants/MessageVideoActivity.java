package com.majomi.zeninstants;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;

public class MessageVideoActivity extends SherlockActivity {
	
	private MessageTextEntity entity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_message_video);
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		
		entity = (MessageTextEntity) getIntent().getExtras().getSerializable("MESSAGE");
		
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_message_video, menu);
		return true;
	}
}
