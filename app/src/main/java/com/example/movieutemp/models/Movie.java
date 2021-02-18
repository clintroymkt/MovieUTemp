package com.example.movieutemp.models;

public class Movie {

    private String title;
    private String description;
    private int Thumbnail;
    private String studio;
    private String rating;
    private String streamingLink;
    private int coverPhoto;


    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        Thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        Thumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        Thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }


    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
