package com.affinityapps.popularmoviesstage2.Favorites;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites_list")
public class Favorite {


    @PrimaryKey(autoGenerate = true)
    private int favoritesId;

    private int favoritesTitle;


    public Favorite(int favoritesTitle) {
        this.favoritesTitle = favoritesTitle;
    }


    public void setFavoritesId(int favoritesId) {
        this.favoritesId = favoritesId;
    }

    public int getFavoritesId() {
        return favoritesId;
    }

    public int getFavoritesTitle() {
        return favoritesTitle;
    }



}
