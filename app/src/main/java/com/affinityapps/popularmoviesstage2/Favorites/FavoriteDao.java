package com.affinityapps.popularmoviesstage2.Favorites;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.affinityapps.popularmoviesstage2.Movie;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert
    void insert(Favorite favorite);

    @Update
    void update(Favorite favorite);

    @Delete
    void delete(Favorite favorite);

    @Query("SELECT * FROM favorites_list ORDER BY favoritesId DESC")
    LiveData<List<Favorite>> getAllFavories();
}