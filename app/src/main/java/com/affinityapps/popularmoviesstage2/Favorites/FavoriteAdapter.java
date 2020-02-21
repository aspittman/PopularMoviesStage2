package com.affinityapps.popularmoviesstage2.Favorites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.affinityapps.popularmoviesstage2.Main.MovieAdapter;
import com.affinityapps.popularmoviesstage2.Movie;
import com.affinityapps.popularmoviesstage2.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteItemsViewHolder> {

    private List<Favorite> favorites = new ArrayList<>();


    public class FavoriteItemsViewHolder extends RecyclerView.ViewHolder {

        private TextView favoriteTitleTextView;
        private TextView favoriteIdTextView;


        public FavoriteItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            favoriteTitleTextView = itemView.findViewById(R.id.favorite_movie_title);
            favoriteIdTextView = itemView.findViewById(R.id.favorite_movie_id);

        }
    }

    @NonNull
    @Override
    public FavoriteItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_items, parent, false);
        FavoriteItemsViewHolder favoriteItemsViewHolder = new FavoriteItemsViewHolder(view);
        return favoriteItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteItemsViewHolder holder, int position) {

        Favorite favorite = favorites.get(position);
        holder.favoriteTitleTextView.setText(favorite.getFavoritesTitle());
        holder.favoriteIdTextView.setText(String.valueOf(favorite.getFavoritesId()));
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
        notifyDataSetChanged();
    }

    public Favorite getFavoritesAt(int position) {
        return favorites.get(position);
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

}
