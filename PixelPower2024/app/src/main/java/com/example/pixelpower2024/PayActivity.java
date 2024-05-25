package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PayActivity extends AppCompatActivity {


    Button backEvent;
    Button hostEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pay);
            hostEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PayActivity.this, OrganizationFeedActivity.class);
                    startActivity(intent);

                    Toast.makeText(PayActivity.this, "You are hosting the event!", Toast.LENGTH_SHORT).show();

                }
            });


            backEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PayActivity.this, OrganizationFeedActivity.class);
                    startActivity(intent);
                }
            });
    }
}