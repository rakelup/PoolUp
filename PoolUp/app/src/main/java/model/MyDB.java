package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import poolup.penguins.chocolate.com.poolup.User;

/**
 * Created by demouser on 8/1/14.
 */
public class MyDB{

    private MyDatabaseHelper dbHelper;

    private SQLiteDatabase database;

    public final static String USER_TBL="Users"; // name of table
    public final static String ROUTE_TBL="Routes";
    public final static String USER_NAME = "_name";
    public final static String USER_PASS = "password";
    public final static String USER_PHONE = "telephone";
    /**
     *
     * @param context
     */
    public MyDB(Context context){
        dbHelper = new MyDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public long addUser(User user){
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(USER_PASS, user.getPassword());
        values.put(USER_PHONE, user.getPhoneNumber());
        return database.insert(USER_TBL, null, values);
    }

    public User selectUser(String name) {
        String[] args = {name};
        String query = "SELECT * FROM " + USER_TBL + " WHERE " + USER_NAME + " = ?";

        Cursor cursor = database.rawQuery(query, args);
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex(USER_PASS));
        String phoneNumber = cursor.getString(cursor.getColumnIndex(USER_PHONE));
        User user = new User(name, phoneNumber, password);
        return user;
    }
}