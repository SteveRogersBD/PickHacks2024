package com.example.thethirdeye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thethirdeye.Models.Model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{

    ArrayList<Model> list;
    Context context;
    DatabaseReference databaseReference;

    public MainAdapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
        databaseReference = FirebaseDatabase.getInstance().getReference().child("attendance");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = list.get(position);
        holder.name_tv.setText(model.getName());
        holder.time_tv.setText(model.getTimeStamp());

        // Decode the Base64 encoded image string and set it to the ImageView
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_tv, time_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_tv = itemView.findViewById(R.id.name_tv);
            time_tv = itemView.findViewById(R.id.time_tv);
        }
    }
}
