package com.example.movienow.utils;

/**
 * doannd
 *
 * Url builder utils
 */
public class UrlBuilder {

    /**
     * base url: https://image.tmdb.org/t/p
     * file size: w342
     * file path: %s ==> example: /kqjL17yufvn9OVLyXYpvtyrFfak.jpg
     *
     * ==> example poster image url: https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg
     */
    private static final String BASE_URL_POSTER = "https://image.tmdb.org/t/p/w342/%s";

    public static String getPosterUrl(String path) {
        return String.format(BASE_URL_POSTER, path);
    }

}
