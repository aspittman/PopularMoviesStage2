package com.affinityapps.popularmoviesstage2.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.affinityapps.popularmoviesstage2.R;
import com.squareup.picasso.Picasso;

import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_MOVIE_ID;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_PLOT_SYNOPSIS;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_RELEASE_DATE;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_TITLE;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_URL;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_VOTE_AVERAGE;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String movieImageUrl2 = intent.getStringExtra(EXTRA_URL);
        String movieTitle2 = intent.getStringExtra(EXTRA_TITLE);
        String movieReleaseDate2 = intent.getStringExtra(EXTRA_RELEASE_DATE);
        int movieVoteAverage2 = intent.getIntExtra(EXTRA_VOTE_AVERAGE, 0);
        String moviePlotSynopsis2 = intent.getStringExtra(EXTRA_PLOT_SYNOPSIS);

        //Movie id below gets parsed into the url for reviews and trailers
        int movieId2 = intent.getIntExtra(EXTRA_MOVIE_ID, 0);

        ImageView imageView = findViewById(R.id.detail_movie_poster);
        TextView textViewTitle = findViewById(R.id.detail_movie_title);
        TextView textViewReleaseDate = findViewById(R.id.detail_release_date);
        TextView textViewVoteAverage = findViewById(R.id.detail_vote_average);
        TextView textViewPlotSynopsis = findViewById(R.id.detail_plot_synopsis);

        Picasso.get().load(movieImageUrl2).
                placeholder(R.drawable.ic_local_movies_black_24dp).
                error(R.drawable.ic_block_black_24dp).
                into(imageView);

        textViewTitle.setText(movieTitle2);
        textViewReleaseDate.setText(movieReleaseDate2);
        textViewVoteAverage.setText(movieVoteAverage2 + "/10");
        textViewPlotSynopsis.setText(moviePlotSynopsis2);

    }
    // Replace 157336 with an parse id of the movies on the MainActivity list
    // http://api.themoviedb.org/3/movie/157336/videos?api_key=0985d7dead91a911264472433eb9c5dc
    // http://api.themoviedb.org/3/movie/157336/reviews?api_key=0985d7dead91a911264472433eb9c5dc
    // Parse the id key from the other two urls to put into these urls
}
