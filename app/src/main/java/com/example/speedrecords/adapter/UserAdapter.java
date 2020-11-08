package com.example.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedrecords.R;
import com.example.speedrecords.model.Record;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private Record[] mUsers;

    public UserAdapter(Context context, Record[] users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_speed, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Record user = mUsers[position];
        Double a =(user.meter/1000.0)/(user.time/3600.0);
        holder.meter.setText(user.meter.toString()+" METERS,");
        holder.time.setText(user.time.toString()+" SECONDS");
        holder.metertime.setText(a.toString());


        //holder.genderImageView.setImageResource(
                //((user.meter/1000.0)/(user.time/3600.0)) > 80.0 ? R.drawable.red_cow : null
       // );
    }

    @Override
    public int getItemCount() {
        return mUsers.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView meter;
        TextView time;
        TextView metertime;
        ImageView genderImageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.meter = itemView.findViewById(R.id.textView6);
            this.time = itemView.findViewById(R.id.textView9);
            this.metertime=itemView.findViewById(R.id.textView5);
            this.genderImageView = itemView.findViewById(R.id.imageView);

        }
    }
}

