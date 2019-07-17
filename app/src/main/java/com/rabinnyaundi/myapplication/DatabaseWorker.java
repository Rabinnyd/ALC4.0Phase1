package com.rabinnyaundi.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.rabinnyaundi.myapplication.ALC4Phase1DatabaseContract.ProfileEntity;

public class DatabaseWorker {

    public static void  initDatabaseValues(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(ProfileEntity.COLUMN_IMAGE, R.drawable.rabin_nyaundi);
        values.put(ProfileEntity.COLUMN_NAME, "Rabin Nyaundi");
        values.put(ProfileEntity.COLUMN_TRACK, "Android");
        values.put(ProfileEntity.COLUMN_COUNTRY, "Kenya");
        values.put(ProfileEntity.COLUMN_PHONE_NUMBER, "254700304978");
        values.put(ProfileEntity.COLUMN_EMAIL_ADDRESS, "rabin.nyaundi254@gmail.com");

        insertProfile(db, values);
    }

    private static void insertProfile(SQLiteDatabase db, ContentValues values) {
        db.insert(ProfileEntity.TABLE_NAME,null,values);
    }

}
