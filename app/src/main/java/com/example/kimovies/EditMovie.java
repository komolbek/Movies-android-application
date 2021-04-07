package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditMovie extends AppCompatActivity {

    StorageManager storageManager;

    private String selectedName;
    private int selectedID;
    private String selectedYear;
    private String selectedDirector;
    private String selectedisFavourite;
    private String selectedRate;
    private String selectedReview;

    private EditText titleText;
    private EditText yearText;
    private EditText directorText;
    private EditText rateText;
    private EditText reviewText;

    private CheckBox checkBox;

    private Button updateButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        storageManager = new StorageManager(this);

        this.setupEditTexts();
        this.setupButtons();
        this.setupButtonListeners();

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedYear = receivedIntent.getStringExtra("year");
        selectedDirector = receivedIntent.getStringExtra("director");
        selectedisFavourite = receivedIntent.getStringExtra("isFavourite");
        selectedRate = receivedIntent.getStringExtra("rate");
        selectedReview = receivedIntent.getStringExtra("review");

        Log.i("NAME info", selectedName);// check data
        titleText.setText(selectedName);
        yearText.setText(selectedYear);
        directorText.setText(selectedDirector);
        rateText.setText(selectedRate);
        reviewText.setText(selectedReview);

        if (Integer.parseInt(selectedisFavourite) == 0) {
            checkBox.setActivated(false);
        } else {
            checkBox.setActivated(true);
        }
    }

    private void setupEditTexts() {
        titleText = (EditText) findViewById(R.id.editMovieTitleEditText);
        yearText = (EditText) findViewById(R.id.editMovieYearEditText);
        directorText = (EditText) findViewById(R.id.editMovieDirectorText);
        rateText = (EditText) findViewById(R.id.editMovieRateText);
        reviewText = (EditText) findViewById(R.id.editMovieReviewText);

        checkBox = (CheckBox) findViewById(R.id.editMovieCheckBox);
    }

    private  void setupButtons() {
        updateButton = (Button) findViewById(R.id.editMovieUpdateButton);
        backButton = (Button) findViewById(R.id.editMovieBackButton);
    }

    private void setupButtonListeners() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info", "Save button clicked");

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