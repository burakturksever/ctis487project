package com.aytugburak.peopleperson.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME="flagsDB"; //DB NAME?
    private static int  DATABASE_VERSION = 1;

    SQLiteDatabase db;

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        db= getWritableDatabase();//Wirtable and Readable mode
        Log.d("DATABASE OPERATIONS","Connection Provided");
    }

    public void close(){
        if(db != null)
            db.close();//Wirtable and Readable mode
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //onCreate called if database doesn't exist
        try {
            sqLiteDatabase.execSQL(ContactDB.CREATE_TABLE_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Log.d("DATABASE OPERATIONS","OnCreate, table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //onUpgrade called ven DATABASE_VERSION is changed
        //SQLiteDatabase object used to execute SQL statements
        try {
            sqLiteDatabase.execSQL(ContactDB.DROP_TABLE_SQL);

        }catch (SQLException e){
            e.printStackTrace();
        }
        onCreate(sqLiteDatabase);
        Log.d("DATABASE OPERATIONS","onUpgrade,  table dropped, old version "+oldVersion+" new version "+newVersion);
    }
    public Cursor getAllRecords(String tableName, String[] columns   ){

        Cursor cursor = db.query(tableName, columns, null, null, null, null, null );

        Log.d("DATABASE OPERATIONS", "GET THE RECORDS");
        return cursor;
    }
}
