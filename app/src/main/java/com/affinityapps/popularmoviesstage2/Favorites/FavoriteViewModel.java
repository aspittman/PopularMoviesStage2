package com.affinityapps.popularmoviesstage2.Favorites;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.affinityapps.popularmoviesstage2.Movie;
import java.util.ArrayList;
import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {
    private FavoriteRepository favoriteRepository;
    private LiveData<List<Favorite>> allFavorites;

    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        favoriteRepository = new FavoriteRepository(application);
        allFavorites = favoriteRepository.getAllFavorites();
    }

    public void insert(Favorite favorite) { favoriteRepository.insert(favorite); }

    public void update(Favorite favorite) {
        favoriteRepository.update(favorite);
    }

    public void delete(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }

    public LiveData<List<Favorite>> getAllFavorites() {
        return allFavorites;
    }
}
