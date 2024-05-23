package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedActivity extends AppCompatActivity {

    ImageButton profileButton;
    Button ongButton;
    Button eventButton;
    GridView gridView;
    SearchView searchView;
    GridAdapter adapter;
    String[] orgNames = {"Org 1", "Org 2", "Org 3", "Org 4","Org 5"};
    int[] orgImages = {R.drawable.org1, R.drawable.org2, R.drawable.org3, R.drawable.org4,R.drawable.org5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ongButton = findViewById(R.id.ongButton);
        eventButton=findViewById(R.id.eventButton);
        profileButton=findViewById(R.id.profileButton);
        gridView = findViewById(R.id.gridView);
        searchView = findViewById(R.id.searchView);
        adapter = new GridAdapter(this, orgNames, orgImages);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedOrgName = adapter.getFilteredOrgNames()[position];
            int selectedOrgImage = adapter.getFilteredOrgImages()[position];
            Intent intent = new Intent(FeedActivity.this, DetailsActivity.class);
            intent.putExtra("name", selectedOrgName);
            intent.putExtra("image", selectedOrgImage);
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
                Intent intent = new Intent(FeedActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
