package com.ldnr.punissement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ldnr.punissement.model.Trainee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "punissement_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create Trainees table
        db.execSQL(Trainee.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Trainee.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public long insertTrainee(Trainee Trainee) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Trainee.COLUMN_FIRSTNAME, Trainee.getFirstName());
        values.put(Trainee.COLUMN_LASTNAME, Trainee.getLastName());

        // insert row
        long id = db.insert(Trainee.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Trainee getTrainee(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Trainee.TABLE_NAME,
                new String[]{Trainee.COLUMN_ID, Trainee.COLUMN_FIRSTNAME, Trainee.COLUMN_LASTNAME},
                Trainee.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Trainee object
        Trainee trainee = new Trainee(
                cursor.getInt(cursor.getColumnIndex(Trainee.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_FIRSTNAME)),
                cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_LASTNAME)),
                cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_PHONE)),
                cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_EMAIL))
                );

        // close the db connection
        cursor.close();

        return trainee;
    }

    public List<Trainee> getAllTrainees() {
        List<Trainee> trainees = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Trainee.TABLE_NAME + " ORDER BY " +
                Trainee.COLUMN_LASTNAME + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Trainee trainee = new Trainee();
                trainee.setId(cursor.getInt(cursor.getColumnIndex(trainee.COLUMN_ID)));
                trainee.setFirstName(cursor.getString(cursor.getColumnIndex(trainee.COLUMN_FIRSTNAME)));
                trainee.setLastName(cursor.getString(cursor.getColumnIndex(trainee.COLUMN_LASTNAME)));

                trainees.add(trainee);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return Trainees list
        return trainees;
    }

    public int getTraineesCount() {
        String countQuery = "SELECT  * FROM " + Trainee.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateTrainee(Trainee Trainee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Trainee.COLUMN_FIRSTNAME, Trainee.getFirstName());
        values.put(Trainee.COLUMN_LASTNAME, Trainee.getLastName());

        // updating row
        return db.update(Trainee.TABLE_NAME, values, Trainee.COLUMN_ID + " = ?",
                new String[]{String.valueOf(Trainee.getId())});
    }

    public void deleteTrainee(Trainee Trainee) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Trainee.TABLE_NAME, Trainee.COLUMN_ID + " = ?",
                new String[]{String.valueOf(Trainee.getId())});
        db.close();
    }
}
