package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CreateMovie extends AppCompatActivity {

    private EditText titleText;
    private EditText yearText;
    private EditText directorText;
    private EditText castText;
    private EditText rateText;
    private EditText reviewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);
    }

    private void setupEditText
}