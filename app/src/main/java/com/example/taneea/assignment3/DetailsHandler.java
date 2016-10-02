package com.example.taneea.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taneea on 02-10-2016.
 */
public class DetailsHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DB_NAME = "DetailsManager";

    private static final String TABLE_DETAILS = "DetailsTable";

    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "gender";
    private static final String TAG = "DetailsHandler";

    public DetailsHandler(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DETAILS_TABLE = "CREATE TABLE " + TABLE_DETAILS + "("
                + KEY_EMAIL + " STRING PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AGE + " TEXT," + KEY_GENDER + " TEXT" + ")";
        db.execSQL(CREATE_DETAILS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAILS);

        onCreate(db);
    }

    void addDetails(Details details) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, details.getEmail());
        values.put(KEY_NAME, details.getName());
        values.put(KEY_AGE, details.getAge());
        values.put(KEY_GENDER, details.getGender());
        Log.d(TAG,values.toString());
        // Inserting Row
        db.insert(TABLE_DETAILS, null, values);
        db.close(); // Closing database connection
    }

    public List<Details> getAllDetails() {
        List<Details> AllDetails = new ArrayList<Details>();
        List<String> IndElem = new ArrayList<String>();
        String ListCommand = "SELECT  * FROM " + TABLE_DETAILS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(ListCommand, null);

        if (cur.moveToFirst()) {
            do {
                Details record = new Details();
                record.setEmail(cur.getString(0));
                record.setName(cur.getString(1));
                record.setGender(cur.getString(2));
                record.setAge(cur.getString(3));
                AllDetails.add(record);
                System.out.println(record.getName() + " who is a " +
                        record.getGender() + " has email id " + record.getEmail() +
                        " and is " + record.getAge() + "years old.");
            } while (cur.moveToNext());
        }
        return AllDetails;
    }

    public int updateDetails(Details details) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, details.getName());
        values.put(KEY_AGE, details.getAge());
        values.put(KEY_GENDER, details.getGender());

        // updating row
        return db.update(TABLE_DETAILS, values, KEY_EMAIL + " = ?",
                new String[] { String.valueOf(details.getEmail()) });
    }

    public void deleteDetails(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DETAILS, KEY_EMAIL + " = ?",
                new String[] { String.valueOf(email) });
        Log.d(TAG, email);
        getAllDetails();
        db.close();
    }
}
