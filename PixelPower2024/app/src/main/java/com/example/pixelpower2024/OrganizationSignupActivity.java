package com.example.pixelpower2024;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.provider.OpenableColumns;
import android.content.ClipData;
import android.view.DragEvent;
import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrganizationSignupActivity extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton, addFilesButton;
    List<Uri> selectedFiles = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);

                Toast.makeText(OrganizationSignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrganizationSignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrganizationSignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signupName.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (action) {
                    case DragEvent.ACTION_DROP:
                        ClipData clipData = event.getClipData();
                        if (clipData != null) {
                            for (int i = 0; i < clipData.getItemCount(); i++) {
                                ClipData.Item item = clipData.getItemAt(i);
                                Uri uri = item.getUri();
                                selectedFiles.add(uri);
                                // Handle dropped file URI here
                                Toast.makeText(OrganizationSignupActivity.this, "File added: " + uri.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        return true;
                }
                return true;
            }
        });
    }

    // Method to open file picker
    public void openFilePicker(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data != null) {
                ClipData clipData = data.getClipData();
                if (clipData != null) {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        selectedFiles.add(uri);
                        // Handle selected file URI here
                        Toast.makeText(this, "File added: " + uri.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}

