package com.example.movienow.data;

import com.example.movienow.data.remote.MovieService;

/**
 * doannd
 *
 * manage data from web services, local...
 */

public class DataManager {
    private final MovieService movieService;

    public DataManager(MovieService movieService) {
        this.movieService = movieService;
    }
}
