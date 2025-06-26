package com.example.a1123;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnNext;
    TextView backArrow;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ctivity_register);

    etEmail = findViewById(R.id.etEmail);
    etPassword = findViewById(R.id.etPassword);
    btnNext = findViewById(R.id.btnNext);
    backArrow = findViewById(R.id.backArrow);

    btnNext.setOnClickListener(v -> {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    });

    backArrow.setOnClickListener(v -> finish());

    btnNext.setOnClickListener(v -> {
        // Get values
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        // TODO: Proceed to next registration step or validate/save
    });
}
}
