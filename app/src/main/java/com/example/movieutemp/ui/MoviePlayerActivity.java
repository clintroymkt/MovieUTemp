package com.example.movieutemp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.movieutemp.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MoviePlayerActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    public static final String VIDEO_TEST_URL="https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullscreen();
        setContentView(R.layout.activity_movie_player);
        hideActionbar();

        playerView = findViewById(R.id.movie_exo_player);
        iniExoPlayer(getIntent().getStringExtra("url"));

        
    }

    private void hideActionbar() {
        getSupportActionBar().hide();
    }

    private void setFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void iniExoPlayer(String url) {

        playerView = findViewById(R.id.movie_exo_player);
        simpleExoPlayer  =  ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this,"appname"));
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(VIDEO_TEST_URL));
        simpleExoPlayer.prepare(videoSource);
        simpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}