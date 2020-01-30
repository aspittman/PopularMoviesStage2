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

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerItemsViewHolder> {

    private ArrayList<Movie> trailersArrayList;
    private Context context;
    private OnLinkClickListener listener;


    public interface OnLinkClickListener {
        void onLinkClick(int position);
    }

    public void setOnLinkClickListener(OnLinkClickListener listener) {
        this.listener = listener;
    }


    public TrailersAdapter(Context context, ArrayList<Movie> trailersArrayList) {
        this.trailersArrayList = trailersArrayList;
        this.context = context;
    }

    public class TrailerItemsViewHolder extends RecyclerView.ViewHolder {

        private ArrayList<Movie> trailersArrayList;
        private ImageView trailerImage;

        public TrailerItemsViewHolder(@NonNull View itemView, ArrayList<Movie> trailersArrayList) {
            super(itemView);

            trailerImage = itemView.findViewById(R.id.trailer_image_icon);
            this.trailersArrayList = trailersArrayList;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onLinkClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public TrailerItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_items, parent, false);
        TrailerItemsViewHolder trailerItemsViewHolder = new TrailerItemsViewHolder(view, trailersArrayList);
        return trailerItemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerItemsViewHolder holder, int position) {

        Movie trailer = trailersArrayList.get(position);
        holder.trailerImage.setImageResource(trailer.getTrailerPlayImage());
    }

    @Override
    public int getItemCount() {
        return trailersArrayList.size();
    }

}
