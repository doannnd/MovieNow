package com.example.movienow.data.remote;

import com.example.movienow.data.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author doannd
 *
 * get API from: https://api.themoviedb.org/3/
 */
public interface MovieService {

    @GET("movie/popular")
    Observable<Response> getPopularMovies(@Query("api_key") String apiKey);

}
