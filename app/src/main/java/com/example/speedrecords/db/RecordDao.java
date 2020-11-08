package com.example.speedrecords.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.speedrecords.model.Record;
@Dao
public interface RecordDao {


        @Query("SELECT * FROM records")
        Record[] getAllUsers();

        @Query("SELECT * FROM records WHERE id = :id")
        Record getUserById(int id);

        @Insert
        void addUser(Record... users);

        @Delete
        void deleteUser(Record user);

}
