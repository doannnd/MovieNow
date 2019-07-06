package com.example.movienow.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class Movie {
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    @SerializedName("overview")
    private String overview;
    @Expose
    @SerializedName("adult")
    private boolean adult;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;
    @Expose
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @Expose
    @SerializedName("original_title")
    private String originalTitle;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("popularity")
    private double popularity;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("vote_average")
    private double voteAverage;
    @Expose
    @SerializedName("video")
    private boolean video;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("vote_count")
    private int voteCount;
}
