package com.affinityapps.popularmoviesstage2.Favorites;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites_list")
public class Favorite {


    @PrimaryKey(autoGenerate = true)
    private int favoritesId;

    private String favoritesTitle;


    public Favorite(String favoritesTitle) {
        this.favoritesTitle = favoritesTitle;
    }


    public void setFavoritesId(int favoritesId) {
        this.favoritesId = favoritesId;
    }

    public int getFavoritesId() {
        return favoritesId;
    }

    public String getFavoritesTitle() {
        return favoritesTitle;
    }



}
