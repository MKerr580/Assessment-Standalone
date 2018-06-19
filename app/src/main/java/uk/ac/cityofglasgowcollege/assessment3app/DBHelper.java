package uk.ac.cityofglasgowcollege.assessment3app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 30130705 on 19/02/2018.
 */

class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="GlasgowCityDB1";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="UserInfo";
    private static final String TABLE_REVIEWS="UserReviews";
    private static final String TABLE_LOCATIONS="Locations";


//creating the command to build  database for user info
    private static final String DATABASE_CREATE="CREATE TABLE UserInfo (firstname text not null," +
            "lastname text not null, " + "email text not null," +
            "address text not null," + "city text not null," + "postcode text not null," +
            "username text not null," + "password text not null);";
//creating the command to build databse for user reviews
    private static final String DATABASE_CREATE2 ="CREATE TABLE UserReviews(usersname text not null, userscomment text not null, userrating integer not null, locationid integer not null, datesubmission text not null);";

    DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase db){
//building the databases
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE2);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //code for updating old tables
        String query="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
        String query2="DROP TABLE IF EXISTS " + TABLE_REVIEWS;
        db.execSQL(query2);
        this.onCreate(db);

    }
}
