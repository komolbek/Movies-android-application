package com.example.kimovies;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayMovies extends AppCompatActivity {

    ListView listView;
    private StorageManager storageManager;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        this.listView = (ListView) findViewById(R.id.favouriteMoviesListView);
        this.backButton = (Button) findViewById(R.id.displayMoviesBackButton);
        this.storageManager = new StorageManager(this);

        this.setupListView();
        this.setupListViewListener();
        this.setupButtonListeners();
    }

    private void setupButtonListeners() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

    private void setupListViewListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String movieName = adapterView.getItemAtPosition(i).toString();
                Log.d("D", "onItemClick: You Clicked on " + movieName);

                Cursor dataID = storageManager.getItemID(movieName);

                int itemID = -1;
                while(dataID.moveToNext()){
                    itemID = dataID.getInt(0);
                }

                Cursor data = storageManager.getItemById(String.valueOf(itemID));
                data.moveToFirst();

                if(itemID > -1){
                    Log.d("D", "onItemClick: The ID is: " + itemID);

                    // TODO: Update items isFavourite column using selected id
                } else{
                    Log.d("D", "No ID with that name");
                }
            }
        });
    }
}