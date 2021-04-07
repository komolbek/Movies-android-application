package com.example.kimovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StorageManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "KIMovies.db";
    public static final String TABLE_NAME = "KIMovies_movies";
    public static final String COL1 = "ID";
    public static final String COL2 = "title";
    public static final String COL3 = "year";
    public static final String COL4 = "director";
    public static final String COL5 = "cast";
    public static final String COL6 = "rate";
    public static final String COL7 = "review";


    public StorageManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME
                + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL2 + " TEXT,"
                + COL3 + " TEXT,"
                + COL4 + " TEXT,"
                + COL5 + "TEXT,"
                + COL6 + " TEXT,"
                + COL7  + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addCreateData(
            String title,
            String year,
            String director,
            String cast,
            String rate,
            String review) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, title);
        contentValues.put(COL3, year);
        contentValues.put(COL4, director);
        contentValues.put(COL5, cast);
        contentValues.put(COL6, rate);
        contentValues.put(COL7, review);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
