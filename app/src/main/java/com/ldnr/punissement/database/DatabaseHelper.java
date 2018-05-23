package com.ldnr.punissement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ldnr.punissement.model.Trainee;
import com.ldnr.punissement.model.Group;
import com.ldnr.punissement.model.Task;
import com.ldnr.punissement.model.Location;

import java.util.ArrayList;
import java.util.List;


/**
 * t
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
        db.execSQL(Group.CREATE_TABLE);
        db.execSQL(Task.CREATE_TABLE);
        db.execSQL(Location.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Trainee.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Group.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Task.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Location.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    /**********************************************************************************************
     *
     *                                      TRAINEE
     *
     **********************************************************************************************/

    public long insertTrainee(Trainee trainee) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Trainee.COLUMN_FIRSTNAME, trainee.getFirstName());
        values.put(Trainee.COLUMN_LASTNAME, trainee.getLastName());
        values.put(Trainee.COLUMN_PHONE, trainee.getPhone());
        values.put(Trainee.COLUMN_EMAIL, trainee.getEmail());

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
                trainee.setId(cursor.getInt(cursor.getColumnIndex(Trainee.COLUMN_ID)));
                trainee.setFirstName(cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_FIRSTNAME)));
                trainee.setLastName(cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_LASTNAME)));
                trainee.setPhone(cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_PHONE)));
                trainee.setEmail(cursor.getString(cursor.getColumnIndex(Trainee.COLUMN_EMAIL)));

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

    public int updateTrainee(Trainee trainee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(com.ldnr.punissement.model.Trainee.COLUMN_FIRSTNAME, trainee.getFirstName());
        values.put(com.ldnr.punissement.model.Trainee.COLUMN_LASTNAME, trainee.getLastName());
        values.put(com.ldnr.punissement.model.Trainee.COLUMN_PHONE, trainee.getPhone());
        values.put(com.ldnr.punissement.model.Trainee.COLUMN_EMAIL, trainee.getEmail());

        // updating row
        return db.update(com.ldnr.punissement.model.Trainee.TABLE_NAME, values, com.ldnr.punissement.model.Trainee.COLUMN_ID + " = ?",
                new String[]{String.valueOf(trainee.getId())});
    }

    public void deleteTrainee(Trainee trainee) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Trainee.TABLE_NAME, Trainee.COLUMN_ID + " = ?",
                new String[]{String.valueOf(trainee.getId())});
        db.close();
    }

    /**********************************************************************************************
     *
     *                                      GROUP
     *
     **********************************************************************************************/

   public long insertGroup(Group group) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Group.COLUMN_GROUPNAME, group.getGroupName());

        // insert row
        long id = db.insert(Group.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Group getGroup(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Group.TABLE_NAME,
                new String[]{Group.COLUMN_ID, Group.COLUMN_GROUPNAME},
                Group.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Group object
        Group group = new Group(
                cursor.getInt(cursor.getColumnIndex(Group.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Group.COLUMN_GROUPNAME))
        );

        // close the db connection
        cursor.close();

        return group;
    }

    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Group.TABLE_NAME + " ORDER BY " +
                Group.COLUMN_GROUPNAME + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Group group = new Group();
                group.setId(cursor.getInt(cursor.getColumnIndex(Group.COLUMN_ID)));
                group.setGroupName(cursor.getString(cursor.getColumnIndex(Group.COLUMN_GROUPNAME)));

                groups.add(group);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return Groups list
        return groups;
    }

    public int getGroupsCount() {
        String countQuery = "SELECT  * FROM " + Group.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateGroup(Group group) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Group.COLUMN_GROUPNAME, group.getGroupName());

        // updating row
        return db.update(com.ldnr.punissement.model.Group.TABLE_NAME, values, com.ldnr.punissement.model.Group.COLUMN_ID + " = ?",
                new String[]{String.valueOf(group.getId())});
    }

    public void deleteGroup(Group group) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Group.TABLE_NAME, Group.COLUMN_ID + " = ?",
                new String[]{String.valueOf(group.getId())});
        db.close();
    }


    /**********************************************************************************************
     *
     *                                      LOCATION
     *
     **********************************************************************************************/

    public long insertLocation(Location location) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Location.COLUMN_LOCNAME, location.getLocName());

        // insert row
        long id = db.insert(Location.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Location getLocation(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Location.TABLE_NAME,
                new String[]{Location.COLUMN_ID, Location.COLUMN_LOCNAME},
                Location.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Location object
        Location location = new Location(
                cursor.getInt(cursor.getColumnIndex(Location.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Location.COLUMN_LOCNAME))
        );

        // close the db connection
        cursor.close();

        return location;
    }

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Location.TABLE_NAME + " ORDER BY " +
                Location.COLUMN_LOCNAME + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Location location = new Location();
                location.setId(cursor.getInt(cursor.getColumnIndex(Location.COLUMN_ID)));
                location.setLocName(cursor.getString(cursor.getColumnIndex(Location.COLUMN_LOCNAME)));

                locations.add(location);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return locations list
        return locations;
    }

    public int getLocationsCount() {
        String countQuery = "SELECT  * FROM " + Location.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    public int updateLocation(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(com.ldnr.punissement.model.Location.COLUMN_LOCNAME, location.getLocName());

        // updating row
        return db.update(com.ldnr.punissement.model.Location.TABLE_NAME, values, com.ldnr.punissement.model.Location.COLUMN_ID + " = ?",
                new String[]{String.valueOf(location.getId())});
    }

    public void deleteLocation(Location location) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Location.TABLE_NAME, Location.COLUMN_ID + " = ?",
                new String[]{String.valueOf(location.getId())});
        db.close();
    }


    /**********************************************************************************************
     *
     *                                      TASK
     *
     **********************************************************************************************/

    public long insertTask(Task task) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Task.COLUMN_TYPE, task.getTaskName());
        values.put(Task.COLUMN_TASKNAME, task.getTaskName());
        values.put(Task.COLUMN_DATE, task.getDate().toString());
        values.put(Task.COLUMN_LOC, task.getLoc().getId());

        // insert row
        long id = db.insert(Task.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public Task getTask(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Task.TABLE_NAME,
                new String[]{Task.COLUMN_ID, Task.COLUMN_TYPE, Task.COLUMN_TASKNAME},
                Task.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare Task object
        Task task = new Task(
                cursor.getInt(cursor.getColumnIndex(Task.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Task.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndex(Task.COLUMN_TASKNAME)),
                cursor.getString(cursor.getColumnIndex(Task.COLUMN_DATE)),
                cursor.getClass(cursor.getColumnIndex(Task.COLUMN_LOC))
        );

        // close the db connection
        cursor.close();

        return task;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Task.TABLE_NAME + " ORDER BY " +
                Task.COLUMN_DATE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setId(cursor.getInt(cursor.getColumnIndex(Task.COLUMN_ID)));
                task.setType(cursor.getString(cursor.getColumnIndex(Task.COLUMN_TYPE)));
                task.setTaskName(cursor.getString(cursor.getColumnIndex(Task.COLUMN_TASKNAME)));
                task.setDate(cursor.getString(cursor.getColumnIndex(Task.COLUMN_DATE)));
                task.setLoc(cursor.getString(cursor.getColumnIndex(Task.COLUMN_LOC)));

                tasks.add(task);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return Task list
        return tasks;
    }

    public int getTasksCount() {
        String countQuery = "SELECT  * FROM " + Task.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Task.COLUMN_TYPE, task.getType());
        values.put(Task.COLUMN_TASKNAME, task.getTaskName());
        values.put(Task.COLUMN_DATE, task.getDate().toString());
        values.put(Task.COLUMN_LOC, task.getLoc().getId());

        // updating row
        return db.update(com.ldnr.punissement.model.Task.TABLE_NAME, values, com.ldnr.punissement.model.Task.COLUMN_ID + " = ?",
                new String[]{String.valueOf(task.getId())});
    }

    public void deleteTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Task.TABLE_NAME, Task.COLUMN_ID + " = ?",
                new String[]{String.valueOf(task.getId())});
        db.close();
    }

}
