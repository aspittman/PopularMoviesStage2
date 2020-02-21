package com.affinityapps.popularmoviesstage2.Detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.affinityapps.popularmoviesstage2.Favorites.Favorite;
import com.affinityapps.popularmoviesstage2.Favorites.FavoriteAdapter;
import com.affinityapps.popularmoviesstage2.Favorites.FavoriteViewModel;
import com.affinityapps.popularmoviesstage2.Movie;
import com.affinityapps.popularmoviesstage2.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_MOVIE_ID;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_PLOT_SYNOPSIS;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_RELEASE_DATE;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_TITLE;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_URL;
import static com.affinityapps.popularmoviesstage2.Main.MainActivity.EXTRA_VOTE_AVERAGE;

public class DetailActivity extends AppCompatActivity
        implements TrailersAdapter.OnLinkClickListener,
        ReviewsAdapter.OnDescriptionClickListener {

    private ArrayList<Movie> trailerList;
    private ArrayList<Movie> reviewList;
    private RecyclerView trailerRecyclerView;
    private RecyclerView reviewRecyclerView;
    private RecyclerView.LayoutManager trailerLayoutManager;
    private RecyclerView.LayoutManager reviewLayoutManager;
    private TrailersAdapter trailersAdapter;
    private ReviewsAdapter reviewsAdapter;
    private RequestQueue requestTrailerQueue;
    private RequestQueue requestReviewQueue;
    private String trailerJsonPage;
    private String reviewJsonPage;
    private ArrayList<String> trailerIntentSetUp;
    private ArrayList<String> reviewIntentSetUp;
    private Movie movie;
    private Favorite favorite;
    private FavoriteViewModel favoriteViewModel;
    private Button favoriteButton;
    private TextView favoriteTitle;
    private TextView favoriteId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        trailerList = new ArrayList<>();
        trailerIntentSetUp = new ArrayList<>();

        trailerRecyclerView = findViewById(R.id.detail_trailers_recyclerview);
        trailerRecyclerView.setHasFixedSize(true);
        trailerLayoutManager = new LinearLayoutManager(this);
        trailerRecyclerView.setLayoutManager(trailerLayoutManager);
        trailersAdapter = new TrailersAdapter(this, trailerList);
        trailerRecyclerView.setAdapter(trailersAdapter);


        reviewList = new ArrayList<>();
        reviewIntentSetUp = new ArrayList<>();

        reviewRecyclerView = findViewById(R.id.detail_reviews_recyclerview);
        reviewRecyclerView.setHasFixedSize(true);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(reviewLayoutManager);
        reviewsAdapter = new ReviewsAdapter(this, reviewList);
        reviewRecyclerView.setAdapter(reviewsAdapter);


        Intent intent = getIntent();
        String movieImageUrl2 = intent.getStringExtra(EXTRA_URL);
        final String movieTitle2 = intent.getStringExtra(EXTRA_TITLE);
        String movieReleaseDate2 = intent.getStringExtra(EXTRA_RELEASE_DATE);
        int movieVoteAverage2 = intent.getIntExtra(EXTRA_VOTE_AVERAGE, 0);
        String moviePlotSynopsis2 = intent.getStringExtra(EXTRA_PLOT_SYNOPSIS);


        //Movie id below gets parsed into the url for reviews and trailers
        final int movieId2 = intent.getIntExtra(EXTRA_MOVIE_ID, 0);
        trailerJsonPage = "https://api.themoviedb.org/3/movie/"+movieId2+"/videos?api_key=0985d7dead91a911264472433eb9c5dc";
        reviewJsonPage = "https://api.themoviedb.org/3/movie/"+movieId2+"/reviews?api_key=0985d7dead91a911264472433eb9c5dc";

        //Detail Activity Options
        ImageView imageView = findViewById(R.id.detail_movie_poster);
        TextView textViewTitle = findViewById(R.id.detail_movie_title);
        TextView textViewReleaseDate = findViewById(R.id.detail_release_date);
        TextView textViewVoteAverage = findViewById(R.id.detail_vote_average);
        TextView textViewPlotSynopsis = findViewById(R.id.detail_plot_synopsis);

        //Favorite Database Options
        favoriteButton = findViewById(R.id.favorites_button);
        favoriteTitle = findViewById(R.id.favorite_movie_title);
        favoriteId = findViewById(R.id.favorite_movie_id);

        //Detail Activity Input
        Picasso.get().load(movieImageUrl2).
                placeholder(R.drawable.ic_local_movies_black_24dp).
                error(R.drawable.ic_block_black_24dp).
                into(imageView);

        textViewTitle.setText(movieTitle2);
        textViewReleaseDate.setText(movieReleaseDate2);
        textViewVoteAverage.setText(movieVoteAverage2 + "/10");
        textViewPlotSynopsis.setText(moviePlotSynopsis2);

        //Favorite Database input
//        favorite = new Favorite(movie.getTitle());
//        favorite.setFavoritesId(movie.getMovieId());
//
//        favoriteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                favoriteTitle.setText(movie.getTitle());
////                favoriteId.setText(movie.getMovieId());
//                favoriteViewModel.insert(favorite);
//
//            }
//        });

        requestTrailerQueue = Volley.newRequestQueue(this);
        parseTrailerData(trailerJsonPage);

        requestReviewQueue = Volley.newRequestQueue(this);
        parseReviewData(reviewJsonPage);
    }

    public void parseTrailerData(String url) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject results = jsonArray.getJSONObject(i);

                                String trailersKeyPath = results.getString("key");

                                String trailersNamePath = results.getString("name");

                                trailerList.add(new Movie(R.drawable.ic_play_arrow_black_24dp, trailersNamePath));
                                trailerIntentSetUp.add((trailersKeyPath));
                            }

                            trailersAdapter = new TrailersAdapter(DetailActivity.this, trailerList);
                            trailerRecyclerView.setAdapter(trailersAdapter);
                            trailersAdapter.setOnLinkClickListener(DetailActivity.this);

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestTrailerQueue.add(jsonObjectRequest);
    }

    public void parseReviewData(String url) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject results = jsonArray.getJSONObject(i);

                                String reviewsIdPath = results.getString("id");

                                String reviewsAuthorPath = results.getString("author");

                                reviewList.add(new Movie(R.drawable.ic_message_black_24dp, reviewsAuthorPath));
                                reviewIntentSetUp.add((reviewsIdPath));
                            }

                            reviewsAdapter = new ReviewsAdapter(DetailActivity.this, reviewList);
                            reviewRecyclerView.setAdapter(reviewsAdapter);
                            reviewsAdapter.setOnDescriptionClickListener(DetailActivity.this);

                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestReviewQueue.add(jsonObjectRequest);
    }


    @Override
    public void onLinkClick(int position) {
        Intent trailersIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+ trailerIntentSetUp.get(position)));
        startActivity(trailersIntent);
    }

    @Override
    public void onDescriptionClick(int position) {
        Intent reviewsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/review/" + reviewIntentSetUp.get(position)));
        startActivity(reviewsIntent);
    }

    // Replace 157336 with an parse id of the movies on the MainActivity list
    // http://api.themoviedb.org/3/movie/157336/videos?api_key=0985d7dead91a911264472433eb9c5dc
    // http://api.themoviedb.org/3/movie/157336/reviews?api_key=0985d7dead91a911264472433eb9c5dc
    // Parse the id key from the other two urls to put into these urls
    // https://www.youtube.com/watch?v=put key here for trailers
    // https://www.themoviedb.org/review/put id here for reviews
}
