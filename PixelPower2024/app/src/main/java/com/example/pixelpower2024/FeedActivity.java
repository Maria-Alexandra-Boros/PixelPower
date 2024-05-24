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

public class FeedActivity extends AppCompatActivity {

    ImageButton profileButton;
    Button ongButton;
    Button eventButton;
    GridView gridView;
    SearchView searchView;
    GridAdapter adapter;
    List<EventDetails> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        ongButton = findViewById(R.id.ongButton);
        eventButton = findViewById(R.id.eventButton);
        profileButton = findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        searchView = findViewById(R.id.searchView);

        // Initialize event data
        events = new ArrayList<>();
        events.add(new EventDetails("Org 1", R.drawable.org1, "Date 1", "$10", "ofmaria ce sa fac"));
        events.add(new EventDetails("Org 2", R.drawable.org2, "Date 2", "$20", "e foarte greu"));
        events.add(new EventDetails("Org 3", R.drawable.org3, "Date 3", "$30", "schimba astea cu textu"));
        events.add(new EventDetails("Org 4", R.drawable.org4, "Date 4", "$40", "si ca sa schimbi ce mai vrei"));
        events.add(new EventDetails("Org 5", R.drawable.org5, "Date 5", "$50", "gen adaugi etc schimbi in detailsactivity"));

        adapter = new GridAdapter(this, events);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            EventDetails selectedEvent = (EventDetails) adapter.getItem(position);
            Intent intent = new Intent(FeedActivity.this, DetailsActivity.class);
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

        ongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedActivity.this, OngActivty.class);
                startActivity(intent);
            }
        });

        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
