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
    public static final String COL5 = "isFavourite";
    public static final String COL6 = "rate";
    public static final String COL7 = "review";


    public StorageManager(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME
                + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " TEXT, "
                + COL3 + " TEXT, "
                + COL4 + " TEXT, "
                + COL5 + " INTEGER DEFAULT 0, "
                + COL6 + " TEXT, "
                + COL7 + " TEXT);";
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
            String rate,
            String review) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, title);
        contentValues.put(COL3, year);
        contentValues.put(COL4, director);
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

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "
                + COL1 + " FROM " + TABLE_NAME
                + " WHERE " + COL2 + " = '" + name + "'";

        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemById(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery(
                "select * from "
                        + this.TABLE_NAME
                        + " where "
                        + this.COL1 + "='" + id + "'" , null
        );
        return data;
    }
}
