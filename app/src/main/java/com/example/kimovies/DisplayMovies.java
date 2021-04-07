package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayMovies extends AppCompatActivity {

    ListView listView;
    private StorageManager storageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        this.listView = (ListView) findViewById(R.id.displayMoviesListView);
        this.storageManager = new StorageManager(this);

        this.setupListView();
    }

    private void setupListView() {
        Cursor data = storageManager.getData();

        ArrayList<String> listData = new ArrayList<>();

        while(data.moveToNext()){

            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
    }
}