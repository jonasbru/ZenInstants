package com.majomi.zeninstants.settingscontroller;

import java.io.Serializable;
import java.util.ArrayList;

import com.majomi.zeninstants.NetworkManager;
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

	@SuppressWarnings("unchecked")
	private FavoritesManager() {
		this.favoritesNotSended = (ArrayList<Favorite>) Utils.getObjectFromSharedPreferences("favorites");

		if(this.favoritesNotSended == null) {
			this.favoritesNotSended = new ArrayList<Favorite>();
		}
	}
	//******** END Singleton ***********

	private ArrayList<Favorite> favoritesNotSended = new ArrayList<Favorite>();

	public void addFavorite(MessageTextEntity entity) {
		entity.setFavorite(true);

		changeFav(entity);
	}

	public void removeFavorite(MessageTextEntity entity) {
		entity.setFavorite(false);

		changeFav(entity);
	}

	public void favoriteSended(String id, String type) {
		for(Favorite f : this.favoritesNotSended) {
			if(String.valueOf(f.getId()).equals(id) && f.getType().equals(type)) {
				this.favoritesNotSended.remove(f);
				break;
			}
		}
	}

	private void changeFav(MessageTextEntity entity) {
		String type = getFavType(entity);

		boolean founded = false;
		for(Favorite f : this.favoritesNotSended) {
			if(f.getId() == entity.getId() && f.getType() == type) {
				f.setFav(entity.isFavorite());
				founded = true;
				break;
			}
		}

		if(!founded) {
			Favorite f = new Favorite();
			f.setId(entity.getId());
			f.setFav(entity.isFavorite());
			f.setType(type);

			favoritesNotSended.add(f);
		}

		trySendFavs();

		Utils.putObjectIntoSharedPreferences("favorites", this.favoritesNotSended);
	}

	private String getFavType(MessageTextEntity entity) {
		if(entity instanceof MessageImageEntity) {
			return "i";
		} else if(entity instanceof MessageSoundEntity) {
			return "s";
		} else if(entity instanceof MessageVideoEntity) {
			return "v";
		} else {
			return "t";
		}
	}

	@SuppressWarnings("unchecked")
	private void trySendFavs() {
		if(Utils.isNetworkAvailable()) {
			for(Favorite f : (ArrayList<Favorite>)this.favoritesNotSended.clone()) {
				boolean res = NetworkManager.pushNote(String.valueOf(f.getId()), f.getType(), f.isFav() ? "1" : "0");

				if(res) {
//					this.favoritesNotSended.remove(f);
				}
			}
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
