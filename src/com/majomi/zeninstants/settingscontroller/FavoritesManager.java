package com.majomi.zeninstants.settingscontroller;

import java.io.Serializable;
import java.util.ArrayList;

import com.majomi.zeninstants.messagesentities.MessageImageEntity;
import com.majomi.zeninstants.messagesentities.MessageSoundEntity;
import com.majomi.zeninstants.messagesentities.MessageTextEntity;
import com.majomi.zeninstants.messagesentities.MessageVideoEntity;
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

	private ArrayList<Favorite> favoritesNotSended = new ArrayList<Favorite>();

	public void addFavorite(MessageTextEntity entity) {
		entity.setFavorite(true);

		boolean founded = false;
		for(Favorite f : this.favoritesNotSended) {
			if(f.getId() == entity.getId()) {
				f.setFav(true);
				founded = true;
				break;
			}
		}

		if(!founded) {
			Favorite f = new Favorite();
			f.setId(entity.getId());
			f.setFav(true);
			if(entity instanceof MessageImageEntity) {
				f.setType("i");
			} else if(entity instanceof MessageSoundEntity) {
				f.setType("s");
			} else if(entity instanceof MessageVideoEntity) {
				f.setType("v");
			} else {
				f.setType("t");
			}

			favoritesNotSended.add(f);
		}

		trySendFav();
	}

	public void removeFavorite(MessageTextEntity entity) {
		entity.setFavorite(false);
	}

	public void loadFavorites() {
	}

	private void trySendFav() {
		if(Utils.isNetworkAvailable()) {

		}

	}

}

/***
 * Uses less memory than the normal Entity classes
 *
 */
class Favorite implements Serializable{
	private static final long serialVersionUID = -340687877983027455L;

	private long id;
	private String type;
	private boolean fav;




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isFav() {
		return fav;
	}
	public void setFav(boolean fav) {
		this.fav = fav;
	}
}
