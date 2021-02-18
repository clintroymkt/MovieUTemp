package com.example.movieutemp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieutemp.R;
import com.example.movieutemp.adapters.CastAdapter;
import com.example.movieutemp.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.movieutemp.ui.MoviePlayerActivity.VIDEO_TEST_URL;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView  tv_title,tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    String mFileUrl = VIDEO_TEST_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //ini views

        iniViews();
        //setup list cast
        setupRvCast();


    }

    void iniViews() {



        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        //animations setup
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));



        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MovieDetailActivity.this, MoviePlayerActivity.class);
                i.putExtra("url",mFileUrl);
                startActivity(i);
            }
        });
    }

    void setupRvCast(){

        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name",R.drawable.f1));
        mdata.add(new Cast("name",R.drawable.f2));
        mdata.add(new Cast("name",R.drawable.ms));
        mdata.add(new Cast("name",R.drawable.rex));
        mdata.add(new Cast("name",R.drawable.az));

        castAdapter = new CastAdapter(this,mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }



}