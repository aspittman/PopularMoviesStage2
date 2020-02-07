package com.affinityapps.popularmoviesstage2;

public class Movie {

    private String movieImageUrl;
    private String title;
    private String releaseDate;
    private int voteAverage;
    private String plotSynopsis;
    private int movieId;
    private int imagesForDetailLists;
    private String rowNumber;
    private String keyId;


    public Movie (String movieImageUrl, String title, String releaseDate, int voteAverage, String plotSynopsis, int movieId) {
        this.movieImageUrl = movieImageUrl;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.plotSynopsis = plotSynopsis;
        this.movieId = movieId;
    }

    public Movie (int imagesForDetailLists, String rowNumber) {
        this.imagesForDetailLists = imagesForDetailLists;
        this.rowNumber = rowNumber;
    }

    public Movie(String keyId) {
        this.keyId = keyId;
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


    public int getImagesForDetailLists() { return imagesForDetailLists; }

    public void setImagesForDetailLists(int imagesForDetailLists) { this.imagesForDetailLists = imagesForDetailLists; }


    public String getRowNumber() { return rowNumber; }

    public void setRowNumber(String rowNumber) { this.rowNumber = rowNumber; }

    public String getKeyId() { return keyId; }

    public void setKeyId(String keyId) { this.keyId = keyId; }
}
