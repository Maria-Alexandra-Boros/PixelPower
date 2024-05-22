package com.example.pixelpower2024;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView detailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailImage = findViewById(R.id.detailImage);
        detailText = findViewById(R.id.detailText);

        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);

        detailImage.setImageResource(image);
        detailText.setText(name + "\n\nDate: TBD\nPrice: Free\nLocation: Various");
    }
}
