package com.affinityapps.popularmoviesstage2.Favorites;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.affinityapps.popularmoviesstage2.R;
import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView favoriteRecyclerView;
    private ArrayList<Favorite> favoriteData;
    private FavoriteAdapter favoriteAdapter;
    private FavoriteViewModel favoriteViewModel;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        favoriteRecyclerView = findViewById(R.id.movie_recycler_view);
        favoriteRecyclerView.setHasFixedSize(true);
        favoriteRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        favoriteRecyclerView.setItemAnimator(new DefaultItemAnimator());

        favoriteAdapter = new FavoriteAdapter();
        favoriteRecyclerView.setAdapter(favoriteAdapter);

        favoriteViewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        favoriteViewModel.getAllFavorites().observe(this, new Observer<List<Favorite>>() {
            @Override
            public void onChanged(List<Favorite> favorites) {

                favoriteAdapter.setFavorites(favorites);
            }
        });

    }
}
