package com.majomi.zeninstants.settingscontroller;

import java.util.ArrayList;

import android.content.SharedPreferences;

import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.utils.Utils;


public class FavoritesManager {

	//********** Singleton *************
	static private FavoritesManager favoritesManager = null;

	static public FavoritesManager getFavoritesManager() {
		if(favoritesManager == null) {
			favoritesManager = new FavoritesManager();
		}	
		return favoritesManager;
	}

	private FavoritesManager() {

	}
	//******** END Singleton ***********

	public void addFavorite(MessageTextEntity entity) {
		entity.setFavorite(true);
		
		Utils.isNetworkAvailable();
	}

	public void removeFavorite(MessageTextEntity entity) {
		entity.setFavorite(false);
	}
	
	@SuppressWarnings("unchecked")
	public void loadFavorites() {
	}



}
