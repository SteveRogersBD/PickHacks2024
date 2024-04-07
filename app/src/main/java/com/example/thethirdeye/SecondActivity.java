package com.example.thethirdeye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thethirdeye.Models.Model;
import com.example.thethirdeye.databinding.ActivitySecondBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter adapter;
    FirebaseDatabase db;
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseDatabase.getInstance();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Model> list = new ArrayList<>();
        adapter = new MainAdapter(list, SecondActivity.this);
        recyclerView.setAdapter(adapter);

        Query query = FirebaseDatabase.getInstance().getReference().child("attendance");
        query.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Retrieve data from the snapshot
                    String name = snapshot.child("name").getValue(String.class);
                    String timestamp = snapshot.child("timestamp").getValue(String.class);

                    // Create a Model object using the retrieved data
                    Model model = new Model(name, timestamp);

                    // Add the Model object to the list
                    list.add(model);
                }
                // Notify the adapter that the dataset has changed
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(list.size()-1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });
    }

}