package com.example.movienow.data.remote;

import com.example.movienow.data.model.Response;
import com.example.movienow.data.model.Results;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author doannd
 *
 * get API from: https://api.themoviedb.org/3/
 */
public interface MovieService {

    @GET("movie/popular")
    Observable<Response> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Observable<Response> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits")
    Observable<Results> getCastList(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/images")
    Observable<Results> getImages(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}/videos")
    Observable<Results> getVideos(@Query("api_key") String apiKey);

    @GET("search/multi")
    Observable<Response> search(@Query("api_key") String apiKey, @Query("query") String query);

}
