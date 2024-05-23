package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView detailText;
    Button involvedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailImage = findViewById(R.id.detailImage);
        detailText = findViewById(R.id.detailText);
        involvedButton = findViewById(R.id.involvedButton);

        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);

        detailImage.setImageResource(image);
        detailText.setText(name + "\n\nDate: TBD\nPrice: Free\nLocation: Various");

        involvedButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                Toast.makeText(DetailsActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailsActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });

    }


}
