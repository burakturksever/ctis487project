package com.aytugburak.peopleperson.classes;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.database.Cursor;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class ContactDB {
    public static final String TABLE_NAME="contacts";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_SURNAME = "surname";
    public static final String FIELD_BIRTHDATE = "birthDate";
    public static final String FIELD_CATEGORY = "category";
    public static final String FIELD_FAVORITED = "favorited";

    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+
            TABLE_NAME + " ("+FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+ FIELD_NAME +
            " text, "+FIELD_SURNAME+" text, "+FIELD_BIRTHDATE+" text, "+FIELD_CATEGORY+" text,"+
            FIELD_FAVORITED+" integer);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;


    public static List<Contact> getAllContacts(DatabaseHelper db){

        Cursor cursor = db.getAllRecords(TABLE_NAME, null);
        List<Contact> data=new ArrayList<>();
        Contact anItem = null;
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String surname = cursor.getString(2);
            String birthDate = cursor.getString(3);
            String category = cursor.getString(4);
            int tempFavorited = cursor.getInt(5);
            boolean favorited = false;
            if(tempFavorited == 1)
                favorited = true;
            else
                favorited = false;

            anItem= new Contact(name, surname, birthDate, category, favorited);
            data.add(anItem);
        }

        return data;
    }

    public static long insertContact(DatabaseHelper db, String name, String surname, String birthDate, String category, boolean favorited){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_SURNAME, surname);
        contentValues.put(FIELD_BIRTHDATE, birthDate);
        contentValues.put(FIELD_CATEGORY, category);

        int tempFavorited = 0;
        if(favorited)
            tempFavorited = 1;
        else
            tempFavorited = 0;

        contentValues.put(FIELD_FAVORITED, tempFavorited);

        long res = db.insert(TABLE_NAME, contentValues);
        return res;
    }

}
