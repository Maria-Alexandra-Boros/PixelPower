package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    ImageButton profileButton;

    GridView gridView;
    SearchView searchView;
    GridAdapter adapter;
    List<EventDetails> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        profileButton = findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        searchView = findViewById(R.id.searchView);

        // Initialize event data
        events = new ArrayList<>();

        events.add(new EventDetails("Org 2", R.drawable.org2, "Date 2", "$20", "e foarte greu"));

        events.add(new EventDetails("Org 4", R.drawable.org4, "Date 4", "$40", "si ca sa schimbi ce mai vrei"));


        adapter = new GridAdapter(this, events);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            EventDetails selectedEvent = (EventDetails) adapter.getItem(position);
            Intent intent = new Intent(EventActivity.this, DetailsActivity.class);
            intent.putExtra("event", selectedEvent);
            startActivity(intent);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // Not used
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
