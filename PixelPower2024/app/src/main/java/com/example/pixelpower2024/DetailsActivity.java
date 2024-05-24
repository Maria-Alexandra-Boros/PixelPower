package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView detailText;
    TextView detailDate;
    TextView detailPrice;
    TextView detailDescription;
    Button involvedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailImage = findViewById(R.id.detailImage);
        detailText = findViewById(R.id.detailText);
        detailDate = findViewById(R.id.detailDate);
        detailPrice = findViewById(R.id.detailPrice);
        detailDescription = findViewById(R.id.detailDescription);
        involvedButton = findViewById(R.id.involvedButton);

        EventDetails event = (EventDetails) getIntent().getSerializableExtra("event");

        if (event != null) {
            detailImage.setImageResource(event.getImageResourceId());
            detailText.setText(event.getName());
            detailDate.setText("Date: " + event.getDate());
            detailPrice.setText("Price: " + event.getPrice());
            detailDescription.setText("Description: " + event.getDescription());
        }

        involvedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailsActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });
    }
}
