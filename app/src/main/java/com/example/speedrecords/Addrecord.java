package com.example.speedrecords;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.speedrecords.db.AppDatabase;
import com.example.speedrecords.model.Record;
import com.example.speedrecords.util.AppExecutors;

import java.util.Calendar;
import java.util.Date;

public class Addrecord extends AppCompatActivity {


    private EditText meter, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecord);

        meter = findViewById(R.id.editTextNumberDecimal);
        time =findViewById(R.id.editTextNumberDecimal2);
        String s= meter.toString();
        String s2=time.toString();





        Button saveButton = findViewById(R.id.button3);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // อ่านค่าจากช่อง first_name_edit_text, last_name_edit_text
                Double m=Double.parseDouble(s);
                Double t=Double.parseDouble(s2);





                final Record user = new Record(0,m,t);

                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(Addrecord.this);
                        db.userDao().addUser(user);
                        finish();
                    }
                });
            }
        });
    }

    }
