package com.rabinnyaundi.myapplication;

import android.provider.BaseColumns;

public class ALC4Phase1DatabaseContract {

    public ALC4Phase1DatabaseContract() {
    }

    public static final class ProfileEntity implements BaseColumns{

        public static final String TABLE_NAME = "my_profile";

        public static final String COLUMN_IMAGE = "profile_image";
        public static final String COLUMN_NAME = "profile_name";
        public static final String COLUMN_TRACK = "profile_track";
        public static final String COLUMN_COUNTRY = "profile_country";
        public static final String COLUMN_PHONE_NUMBER = "profile_phone_number";
        public static final String COLUMN_EMAIL_ADDRESS = "profile_email_address";


        public static final String SQL_CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_IMAGE + " INTEGER NOT NUll, " +
                COLUMN_NAME + " TEXT NOT NUll, " +
                COLUMN_TRACK + " TEXT NOT NUll, " +
                COLUMN_COUNTRY + " TEXT NOT NUll, " +
                COLUMN_PHONE_NUMBER + " TEXT UNIQUE NOT NUll, " +
                COLUMN_EMAIL_ADDRESS + " TEXT UNIQUE NOT NUll ) " ;


    }
}
