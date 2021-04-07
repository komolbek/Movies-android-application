package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMovie extends AppCompatActivity {

    private StorageManager storageManager;

    private EditText titleText;
    private EditText yearText;
    private EditText directorText;
    private EditText rateText;
    private EditText reviewText;

    private Button saveButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        this.setupEditTexts();
        setupButtons();
        setupButtonListeners();
        this.storageManager = new StorageManager(this);
    }

    private void setupEditTexts() {
        titleText = (EditText) findViewById(R.id.createMovieTitleText);
        yearText = (EditText) findViewById(R.id.createMovieYearText);
        directorText = (EditText) findViewById(R.id.createMovieDirectorText);
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
                Log.i("Info", "Save button clicked");
                handleSaveButton();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleSaveButton() {
        String title = titleText.getText().toString();
        String year = yearText.getText().toString();
        String director = directorText.getText().toString();
        String rate = rateText.getText().toString();
        String review = reviewText.getText().toString();

        if ((title.length() != 0)
                && (year.length() != 0)
                && (director.length() != 0)
                && (rate.length() != 0)
                && (review.length() != 0))
        {
            this.addData(title, year, director, rate, review);
            titleText.setText("");
            yearText.setText("");
            directorText.setText("");
            rateText.setText("");
            reviewText.setText("");

            finish();
        } else {
            logResult("The text field should be Empty!");
        }
    }

    private void addData(
            String title,
            String year,
            String director,
            String rate,
            String review
    ) {
        boolean insertData = storageManager.addCreateData(title, year, director, rate, review);

        if (insertData) {
            Log.i("Info", "Successfully Inserted");
        } else {
            Log.e("Error", "Failed Inserting");
        }
    }

    private void logResult(String resultText){
        Toast.makeText(this,resultText, Toast.LENGTH_SHORT).show();
    }
}