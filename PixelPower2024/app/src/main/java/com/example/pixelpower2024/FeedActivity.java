package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedActivity extends AppCompatActivity {


    GridView gridView;

    Button ongButton;
    Button eventButton;
    String[] orgNames = {"Org 1", "Org 2", "Org 3", "Org 4", "Org 5"};
    int[] orgImages = {R.drawable.org1, R.drawable.org2, R.drawable.org3, R.drawable.org4, R.drawable.org5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ongButton = findViewById(R.id.ongButton);
        eventButton = findViewById(R.id.eventButton);

        gridView = findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(this, orgNames, orgImages);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FeedActivity.this, DetailsActivity.class);
                intent.putExtra("name", orgNames[position]);
                intent.putExtra("image", orgImages[position]);
                startActivity(intent);
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
    }

}
