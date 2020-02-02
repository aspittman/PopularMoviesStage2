package com.affinityapps.popularmoviesstage2.Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.affinityapps.popularmoviesstage2.Main.Movie;
import com.affinityapps.popularmoviesstage2.Main.MovieAdapter;
import com.affinityapps.popularmoviesstage2.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewItemsViewHolder> {

    private ArrayList<Movie> reviewsArrayList;
    private Context context;
    private OnDescriptionClickListener listener;

    public interface OnDescriptionClickListener {
        void onDescriptionClick(int position);
    }

    public void setOnDescriptionClickListener(OnDescriptionClickListener listener) { this.listener = listener; }


    public ReviewsAdapter(Context context, ArrayList<Movie> reviewsArrayList) {
        this.reviewsArrayList = reviewsArrayList;
        this.context = context;
    }

    public class ReviewItemsViewHolder extends RecyclerView.ViewHolder {

        private ArrayList<Movie> reviewsArrayList;
        private ImageView reviewImage;

        public ReviewItemsViewHolder(@NonNull View itemView, ArrayList<Movie> reviewsArrayList) {
            super(itemView);

            reviewImage = itemView.findViewById(R.id.movie_image_icon);
            this.reviewsArrayList = reviewsArrayList;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onDescriptionClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ReviewItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_items, parent, false);
        ReviewItemsViewHolder reviewItemsViewHolder = new ReviewItemsViewHolder(view, reviewsArrayList);
        return reviewItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewItemsViewHolder holder, int position) {

        Movie review = reviewsArrayList.get(position);
        holder.reviewImage.setImageResource(review.getImagesForDetailLists());

    }

    @Override
    public int getItemCount() {
        return reviewsArrayList.size();
    }

}
