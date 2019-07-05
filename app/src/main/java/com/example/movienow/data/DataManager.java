package com.example.movienow.data;

import com.example.movienow.data.model.Response;
import com.example.movienow.data.remote.MovieService;

import io.reactivex.Observable;

/**
 * doannd
 * <p>
 * manage data from web services: https://api.themoviedb.org/3/
 */

public class DataManager {
    private final MovieService movieService;

    public DataManager(MovieService movieService) {
        this.movieService = movieService;
    }

    public Observable<Response> getPopularMovies(String apiKey) {
        return movieService.getPopularMovies(apiKey);
    }
}
