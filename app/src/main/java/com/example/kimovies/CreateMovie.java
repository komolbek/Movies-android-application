package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMovie extends AppCompatActivity {

    private EditText titleText;
    private EditText yearText;
    private EditText directorText;
    private EditText castText;
    private EditText rateText;
    private EditText reviewText;

    private Button saveButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        this.setupEditTexts();
    }

    private void setupEditTexts() {
        titleText = (EditText) findViewById(R.id.createMovieTitleText);
        yearText = (EditText) findViewById(R.id.createMovieYearText);
        directorText = (EditText) findViewById(R.id.createMovieDirectorText);
        castText = (EditText) findViewById(R.id.createMovieCastText);
        rateText = (EditText) findViewById(R.id.createMovieRateText);
        reviewText = (EditText) findViewById(R.id.createMovieReviewText);
    }

    private  void setupButtons() {
        saveButton = (Button) findViewById(R.id.createMovieSaveButton);
        backButton = (Button) findViewById(R.id.createMovieBackButton);
     }

    private void setupButtonListeners() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}