package com.example.speedrecords;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedrecords.adapter.UserAdapter;

import com.example.speedrecords.model.Record;
import com.example.speedrecords.util.AppExecutors;
import  com.example.speedrecords.db.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private RecyclerView mRecyclerView1;

    @Override
    protected void onResume() {
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                final Record[] users = db.userDao().getAllUsers();

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        UserAdapter adapter = new UserAdapter(MainActivity.this, users);
                        mRecyclerView1.setAdapter(adapter);
                    }
                });


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView1 = findViewById(R.id.mRecyclerView);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        TextView total;
        total=findViewById(R.id.textView2);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Addrecord.class);
                startActivity(i);
            }
        });
    }
}