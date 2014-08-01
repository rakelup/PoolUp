package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by demouser on 8/1/14.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PoolUpDB";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_ROUTES = "create table Routes( _id integer primary key ,driver text not null, " +
            "availableSeats text, startPointLatitude integer, startPointLongitute integer, endPointLatitude integer," +
            "endPointLongitude integer, price integer, date text, time text, passengers text);";
    private static final String DATABASE_CREATE_USERS = "create table Users( _name text primary key, " +
            "telephone text, password text);";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_ROUTES);
        database.execSQL(DATABASE_CREATE_USERS);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(MyDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}