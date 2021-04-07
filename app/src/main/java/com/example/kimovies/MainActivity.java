package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createMovieButton;
    private Button displayMoviesButton;
    private Button favouriteMoviesButton;
    private Button editMoviesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setupButtons();
        this.setupButtonListeners();
    }

    private void setupButtons() {
        createMovieButton = (Button) findViewById(R.id.mainCreateMovieButton);
        displayMoviesButton = (Button) findViewById(R.id.mainDisplayMoviesButton);
        favouriteMoviesButton = (Button) findViewById(R.id.mainFavouriteMoviesButton);
        editMoviesButton = (Button) findViewById(R.id.mainDisplayMoviesToEditButton);
    }

    private void setupButtonListeners() {
        createMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateMovieActivity();
            }
        });

        displayMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisplayMoviesActivity();
            }
        });

        favouriteMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFavouriteMoviesActivity();
            }
        });

        editMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDisplayMoviesToEditActivity();
            }
        });
    }

    private void openCreateMovieActivity() {
        Intent intent = new Intent(MainActivity.this, CreateMovie.class);
        startActivity(intent);
    }

    private void openDisplayMoviesActivity() {
        Intent intent = new Intent(MainActivity.this, DisplayMovies.class);
        startActivity(intent);
    }

    private void openFavouriteMoviesActivity() {
        Intent intent = new Intent(MainActivity.this, FavouriteMovies.class);
        startActivity(intent);
    }

    private void openDisplayMoviesToEditActivity() {
        Intent intent = new Intent(MainActivity.this, DisplayMoviesToEdit.class);
        startActivity(intent);
    }
}