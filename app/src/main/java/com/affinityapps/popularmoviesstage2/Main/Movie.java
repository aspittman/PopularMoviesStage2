package com.affinityapps.popularmoviesstage2.Main;

public class Movie {

    private String movieImageUrl;
    private String title;
    private String releaseDate;
    private int voteAverage;
    private String plotSynopsis;
    private int movieId;
    private int trailerPlayImage;

    public Movie (String movieImageUrl, String title, String releaseDate, int voteAverage, String plotSynopsis) {
        this.movieImageUrl = movieImageUrl;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.plotSynopsis = plotSynopsis;
        this.movieId = movieId;
    }


    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    public int getMovieId() { return movieId; }

    public void setMovieId(int movieId) { this.movieId = movieId; }

    public int getTrailerPlayImage() { return trailerPlayImage; }

    public void setTrailerPlayImage(int trailerPlayImage) { this.trailerPlayImage = trailerPlayImage; }
}
