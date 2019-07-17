package com.rabinnyaundi.myapplication;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.rabinnyaundi.myapplication.ALC4Phase1DatabaseContract.ProfileEntity;

public class MyProfileActivity extends AppCompatActivity {

    ImageView imgProfile;
    TextView tvName;
    TextView tvTrack;
    TextView tvEmail;
    TextView tvPhoneNumber;
    TextView tvCountry;

    ALC4Phase1OpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        imgProfile = findViewById(R.id.img_profile);
        tvName = findViewById(R.id.tv_profileName);
        tvTrack = findViewById(R.id.tv_track);
        tvEmail = findViewById(R.id.tv_email);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        tvCountry = findViewById(R.id.tv_country);

        openHelper= new ALC4Phase1OpenHelper(this);

        loadData();
    }

    private void loadData() {
        AsyncTask<String, Integer, Cursor> asyncTask = new AsyncTask<String, Integer, Cursor>() {
            @Override
            protected Cursor doInBackground(String... strings) {

                SQLiteDatabase db = openHelper.getReadableDatabase();
                final String[] profileColumns = {
                        ProfileEntity.COLUMN_IMAGE,
                        ProfileEntity.COLUMN_NAME,
                        ProfileEntity.COLUMN_TRACK,
                        ProfileEntity.COLUMN_COUNTRY,
                        ProfileEntity.COLUMN_EMAIL_ADDRESS,
                        ProfileEntity.COLUMN_PHONE_NUMBER,

                };


                Cursor mCursor = db.query(ProfileEntity.TABLE_NAME,profileColumns,null,
                        null,null,null,null);


                return mCursor;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);

                populateViews(cursor);
            }
        };

        asyncTask.execute();
    }



    private void populateViews(Cursor data) {
        data.moveToNext();

        int imageIdPos = data.getColumnIndex(ProfileEntity.COLUMN_IMAGE);
        int nameIdPos = data.getColumnIndex(ProfileEntity.COLUMN_NAME);
        int trackIdPos = data.getColumnIndex(ProfileEntity.COLUMN_TRACK);
        int countryIdPos = data.getColumnIndex(ProfileEntity.COLUMN_COUNTRY);
        int emailIdPos = data.getColumnIndex(ProfileEntity.COLUMN_EMAIL_ADDRESS);
        int phoneIdPos = data.getColumnIndex(ProfileEntity.COLUMN_PHONE_NUMBER);

        imgProfile.setImageDrawable(getDrawable(data.getInt(imageIdPos)));
        tvName.setText(data.getString(nameIdPos));
        tvTrack.setText(data.getString(trackIdPos));
        tvCountry.setText(data.getString(countryIdPos));
        tvEmail.setText(data.getString(emailIdPos));
        tvPhoneNumber.setText(data.getString(phoneIdPos));
    }
}
