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

public class OngActivty extends AppCompatActivity {

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
        setContentView(R.layout.activity_ong_activty);


        profileButton = findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        searchView = findViewById(R.id.searchView);

        // Initialize event data
        events = new ArrayList<>();
        events.add(new EventDetails("Inimă de Copil", R.drawable.org1, "until 10.09.2024", "any type of monetary or material donation", "Inima de Copil, which translates to Heart of a Child, is a dedicated charity that provides a safe, nurturing, and educational daycare environment for children from disadvantaged backgrounds. The organization focuses on supporting children who face socio-economic hardships, offering them a haven where they can grow, learn, and thrive. Mission: The mission of Inima de Copil is to empower children by providing them with the care, education, and emotional support they need to overcome challenges and reach their full potential. The charity aims to break the cycle of poverty by investing in the next generation, ensuring they have access to opportunities that foster development and well-being.   "));

        events.add(new EventDetails("Interact Club Galați", R.drawable.org3, "until 15.09.2024", "monthly cotization of 3€", "The Interact Club Galați is a vibrant youth-led organization dedicated to community service, leadership development, and cultural exchange. As part of the global network of Interact Clubs, sponsored by Rotary International, the Interact Club Galați empowers young people aged 12-18 to engage in meaningful service projects, build leadership skills, and promote international understanding."));

        events.add(new EventDetails("Fantasticii Down Foundation", R.drawable.org5, "until 4.08.2024", "any type of donation", "The Fantasticii Down Foundation is a compassionate and dedicated organization focused on supporting individuals with Down syndrome and their families. The foundation provides a range of services, programs, and resources aimed at promoting the well-being, inclusion, and empowerment of people with Down syndrome. Through educational initiatives, social activities, and advocacy efforts, the foundation strives to create a supportive community where individuals with Down syndrome can thrive and reach their full potential."));


        adapter = new GridAdapter(this, events);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            EventDetails selectedEvent = (EventDetails) adapter.getItem(position);
            Intent intent = new Intent(OngActivty.this, DetailsActivity.class);
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
                Intent intent = new Intent(OngActivty.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
