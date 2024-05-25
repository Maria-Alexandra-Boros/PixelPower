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
        profileButton = findViewById(R.id.profileEventButton);
        gridView = findViewById(R.id.gridEventView);
        searchView = findViewById(R.id.searchEventView);

        // Initialize event data
        events = new ArrayList<>();

        events.add(new EventDetails("Fund Raising Marathon", R.drawable.org2, "1.06.2024", "minimum donation: 5€", "The Run for Bright Futures Fundraising Marathon is a vibrant and inclusive event designed to support gifted students who face financial barriers in continuing their education. This marathon aims to raise funds to provide these talented students with essential materials such as textbooks, school supplies, laptops, and other educational resources."));
        events.add(new EventDetails("Voluntary work at the „VA Urechia” Library Galați", R.drawable.org4, "24.06.2024 - 20.09.2024", "any monetary or material donation", "Volunteering at the Biblioteca Județeană „VA Urechia” Galați offers a rewarding opportunity to support the local library's mission of providing educational resources, cultural enrichment, and community services. Volunteers play a crucial role in enhancing the library’s operations, programs, and outreach efforts, helping to make the library a welcoming and accessible place for all members of the community."));
        events.add(new EventDetails("Danube River Shore and Promenade Cleaning Event",R.drawable.org1,"8.06.2024","3€ fee that will go to purchasing new equipment for the park near the promenade","The Danube River Shore and Promenade Cleaning Event is a community-driven initiative aimed at preserving the natural beauty and ecological integrity of the Danube River and its surrounding areas. Organized by local environmental groups, community organizations, and concerned citizens, this event brings together volunteers of all ages to participate in a collective effort to clean up litter and debris along the river shore and promenade."));



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
