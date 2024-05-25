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

    ImageButton profileFeedButton;
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

        ongButton = findViewById(R.id.ongFeedButton);
        eventButton = findViewById(R.id.eventFeedButton);
        profileFeedButton = findViewById(R.id.profileFeedButton);
        gridView = findViewById(R.id.gridFeedView);
        searchView = findViewById(R.id.searchFeedView);

        // Initialize event data
        events = new ArrayList<>();
        events.add(new EventDetails("Inimă de Copil", R.drawable.org1, "until 10.09.2024", "any type of monetary or material donation", "Inima de Copil, which translates to Heart of a Child, is a dedicated charity that provides a safe, nurturing, and educational daycare environment for children from disadvantaged backgrounds. The organization focuses on supporting children who face socio-economic hardships, offering them a haven where they can grow, learn, and thrive. Mission: The mission of Inima de Copil is to empower children by providing them with the care, education, and emotional support they need to overcome challenges and reach their full potential. The charity aims to break the cycle of poverty by investing in the next generation, ensuring they have access to opportunities that foster development and well-being."));
        events.add(new EventDetails("Fund Raising Marathon", R.drawable.org2, "1.06.2024", "minimum donation: 5€", "The Run for Bright Futures Fundraising Marathon is a vibrant and inclusive event designed to support gifted students who face financial barriers in continuing their education. This marathon aims to raise funds to provide these talented students with essential materials such as textbooks, school supplies, laptops, and other educational resources."));
        events.add(new EventDetails("Interact Club Galați", R.drawable.org3, "until 15.09.2024", "monthly cotization of 3€", "The Interact Club Galați is a vibrant youth-led organization dedicated to community service, leadership development, and cultural exchange. As part of the global network of Interact Clubs, sponsored by Rotary International, the Interact Club Galați empowers young people aged 12-18 to engage in meaningful service projects, build leadership skills, and promote international understanding."));
        events.add(new EventDetails("Voluntary work at the „VA Urechia” Library Galați", R.drawable.org4, "24.06.2024 - 20.09.2024", "any monetary or material donation", "Volunteering at the Biblioteca Județeană „VA Urechia” Galați offers a rewarding opportunity to support the local library's mission of providing educational resources, cultural enrichment, and community services. Volunteers play a crucial role in enhancing the library’s operations, programs, and outreach efforts, helping to make the library a welcoming and accessible place for all members of the community."));
        events.add(new EventDetails("Fantasticii Down Foundation", R.drawable.org5, "until 4.08.2024", "any type of donation", "The Fantasticii Down Foundation is a compassionate and dedicated organization focused on supporting individuals with Down syndrome and their families. The foundation provides a range of services, programs, and resources aimed at promoting the well-being, inclusion, and empowerment of people with Down syndrome. Through educational initiatives, social activities, and advocacy efforts, the foundation strives to create a supportive community where individuals with Down syndrome can thrive and reach their full potential."));
        events.add(new EventDetails("Danube River Shore and Promenade Cleaning Event",R.drawable.org1,"8.06.2024","3€ fee that will go to purchasing new equipment for the park near the promenade","The Danube River Shore and Promenade Cleaning Event is a community-driven initiative aimed at preserving the natural beauty and ecological integrity of the Danube River and its surrounding areas. Organized by local environmental groups, community organizations, and concerned citizens, this event brings together volunteers of all ages to participate in a collective effort to clean up litter and debris along the river shore and promenade."));

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

        profileFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
