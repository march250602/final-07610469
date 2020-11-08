package com.example.speedrecords.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.speedrecords.model.Record;
import com.example.speedrecords.util.AppExecutors;

import java.util.Calendar;


@Database(entities = {Record.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  private static final String TAG = "AppDatabase";
  private static final String DB_NAME = "user.db";

  private static AppDatabase sInstance;

  public abstract RecordDao userDao();

  public static synchronized AppDatabase getInstance(final Context context) {
    if (sInstance == null) {
      sInstance = Room.databaseBuilder(
              context.getApplicationContext(),
              AppDatabase.class,
              DB_NAME
      ).addCallback(new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
          super.onCreate(db);

        }
      }).build();
    }
    return sInstance;
  }


}