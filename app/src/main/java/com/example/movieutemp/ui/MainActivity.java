package com.example.movieutemp.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.movieutemp.models.Movie;
import com.example.movieutemp.adapters.MovieAdapter;
import com.example.movieutemp.adapters.MovieItemClickListener;
import com.example.movieutemp.R;
import com.example.movieutemp.models.Slide;
import com.example.movieutemp.adapters.SliderPagerAdapter;
import com.example.movieutemp.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV,moviesRvWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();


    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this,DataSource.getWeekMovies(), this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniPopularMovies() {
        //RecyclerView Setup
        //ini




        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        //prepare list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.mk,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.dffdf,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.asemu,"Slide Title \nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);
        //setup timer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);

        indicator.setupWithViewPager(sliderpager,true);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvWeek = findViewById(R.id.rv_movies_week);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        //sending info to detail activity
        Intent intent = new Intent(this,MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        //startActivity(intent);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView,"sharedName");
        startActivity(intent,options.toBundle());

       // Toast.makeText(this,"item clicked: " + movie.getTitle(),Toast.LENGTH_LONG).show();



    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }




}