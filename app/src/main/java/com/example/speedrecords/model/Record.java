package com.example.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "records")
public class Record {

    @PrimaryKey(autoGenerate = true)
    public final int id;
    @ColumnInfo(name = "meter")
    public final Double meter;

    @ColumnInfo(name = "time")
    public final Double time;




    public Record(int id,Double meter,Double time){
        this.id=id;
        this.meter=meter;
        this.time=time;

    }
}
