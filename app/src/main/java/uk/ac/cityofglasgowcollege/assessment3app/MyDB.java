package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 30130705 on 19/02/2018.
 */

public class MyDB {
    //declaring the table and column names from the database
    private static final String TABLE_NAME = "UserInfo";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_POSTCODE = "postcode";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String TABLE_REVIEWS = "UserReviews";
    private static final String COLUMN_USERCOMMENT = "userscomment";
    private static final String COLUMN_USERRATING = "userrating";
    private static final String COLUMN_LOCATIONID = "locationid";
    private static final String COLUMN_USERSNAME = "usersname";
    private static final String COLUMN_DATESUBMISSION = "datesubmission";

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public MyDB(Context context) {
        //calling the database helpoer and creating the databse
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insertuser(User u) {
        //inserting user data gained when this method is called to the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRSTNAME, u.getFirstname());
        values.put(COLUMN_LASTNAME, u.getLastname());
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_ADDRESS, u.getAddress());
        values.put(COLUMN_CITY, u.getCity());
        values.put(COLUMN_POSTCODE, u.getPostcode());
        values.put(COLUMN_USERNAME, u.getUsername());
        values.put(COLUMN_PASSWORD, u.getPassword());
        try {
            database.insert(TABLE_NAME, null, values);
        } catch (SQLiteException ex) {
            Log.e("insert error", ex.toString());
        }
    }

    public void insertuserreview(Review u) {
        ContentValues values = new ContentValues();
        //inserting the user review when this method is called into the database
        values.put(COLUMN_USERCOMMENT, u.getusercomment());
        values.put(COLUMN_USERRATING, u.getuserrating());
        values.put(COLUMN_LOCATIONID, u.getlocationid());
        values.put(COLUMN_USERSNAME, u.getusersname());
        values.put(COLUMN_DATESUBMISSION, u.getdatesubmission());

        try {
            database.insert(TABLE_REVIEWS, null, values);
        } catch (SQLiteException ex) {
            Log.e("insert error", ex.toString());
        }

    }

    public ArrayList<Review> getComments(){
        //obtains the usercomments from the databse and adds them to reviewinfo
        ArrayList<Review> reviewinfo = new ArrayList<>();
        String sqlStr = "Select * FROM UserReviews;";

        Cursor cursor = database.rawQuery(sqlStr, null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                Integer userrating = cursor.getInt(cursor.getColumnIndex(COLUMN_USERRATING));
                String usercomment = cursor.getString(cursor.getColumnIndex(COLUMN_USERCOMMENT));
                Integer locationid = cursor.getInt(cursor.getColumnIndex(COLUMN_LOCATIONID));
                String usersname = cursor.getString(cursor.getColumnIndex(COLUMN_USERSNAME));
                String datesubmission = cursor.getString(cursor.getColumnIndex(COLUMN_DATESUBMISSION));
                Review u = new Review(usersname, usercomment, userrating, locationid, datesubmission);
                reviewinfo.add(u);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return reviewinfo;
    }
    public boolean isValidUser(String Username, String Password) {
        //checks if the username and password submitted in the login page are valid
        String sql = "Select * from UserInfo Where username = ? and password = ? ;";
        String[] args = {Username, Password};
        Cursor cursor = database.rawQuery(sql, args);
        if (cursor.getCount() == 0) {
            return false;
        } else {
            return true;
        }

    }

}
