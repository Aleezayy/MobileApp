package com.example.a1123;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginEmail, etLoginPassword;
    Button btnLoginNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views first
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLoginNow = findViewById(R.id.btnLoginNow);

        // Set button click listener
        btnLoginNow.setOnClickListener(v -> {
            String email = etLoginEmail.getText().toString();
            String password = etLoginPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Implement real login validation
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();

                // Navigate to Discover page
                Intent intent = new Intent(LoginActivity.this, DiscoverActivity.class);
                startActivity(intent);
            }
        });
    }
}
