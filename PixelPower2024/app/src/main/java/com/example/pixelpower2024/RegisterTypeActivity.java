package com.example.pixelpower2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterTypeActivity extends AppCompatActivity {

    private Spinner registerTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_type);


        registerTypeSpinner = findViewById(R.id.registerTypeSpinner);

        Button continueButton = findViewById(R.id.continueButton);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.register_type_array, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        registerTypeSpinner.setAdapter(adapter);


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedType = registerTypeSpinner.getSelectedItem().toString();


                Intent intent;
                if (selectedType.equals("Organization")) {
                    intent = new Intent(RegisterTypeActivity.this, OrganizationSignupActivity.class);
                } else if (selectedType.equals("User")) {
                    intent = new Intent(RegisterTypeActivity.this, SignupActivity.class);
                } else {

                    Toast.makeText(RegisterTypeActivity.this, "Unexpected selection", Toast.LENGTH_SHORT).show();
                    return;
                }


                startActivity(intent);
            }
        });
    }
}
