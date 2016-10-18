package com.example.richellerazon.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by richellerazon on 10/16/16.
 */
public class Movie {
    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public String getBackdropUrl() {
        return String.format("https://image.tmdb.org/t/p/w780%s", backdropPath);
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String backdropPath;
    String originTitle;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray (JSONArray jsonArray) {
        ArrayList<Movie> results = new ArrayList<Movie>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = null;
            try {
                results.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
