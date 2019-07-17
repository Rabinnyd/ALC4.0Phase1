package com.rabinnyaundi.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.rabinnyaundi.myapplication.ALC4Phase1DatabaseContract.ProfileEntity;

public class ALC4Phase1OpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "alc_4.0_phase1.db";
    private static final int DATABASE_VERSION = 1;


    public ALC4Phase1OpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProfileEntity.SQL_CREATE_TABLE);
        DatabaseWorker.initDatabaseValues(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
