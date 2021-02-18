package com.example.movieutemp.utils;

import com.example.movieutemp.R;
import com.example.movieutemp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {




    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("The Mandalorian", R.drawable.mando, R.drawable.birds));
        lstMovies.add(new Movie("Halo",R.drawable.halo, R.drawable.birds));
        lstMovies.add(new Movie("Transformers",R.drawable.trans, R.drawable.birds));
        lstMovies.add(new Movie("WW84",R.drawable.ww84, R.drawable.birds));
        lstMovies.add(new Movie("Azrael",R.drawable.azrael, R.drawable.birds));
        return lstMovies;
    }

    public static List<Movie> getWeekMovies() {
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("WW84",R.drawable.ww84, R.drawable.birds));
        lstMovies.add(new Movie("Azrael",R.drawable.azrael, R.drawable.birds));
        lstMovies.add(new Movie("The Mandalorian", R.drawable.mando, R.drawable.birds));
        lstMovies.add(new Movie("Halo",R.drawable.halo, R.drawable.birds));
        lstMovies.add(new Movie("Transformers",R.drawable.trans, R.drawable.birds));

        return lstMovies;

    }


}
