package com.example.phonebookapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    private EditText editContactName, editContactPhone, editContactEmail;
    private Button saveContactButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editContactName = findViewById(R.id.editContactName);
        editContactPhone = findViewById(R.id.editContactPhone);
        editContactEmail = findViewById(R.id.editContactEmail);
        saveContactButton = findViewById(R.id.saveContactButton);
        cancelButton = findViewById(R.id.cancelButton);

        saveContactButton.setOnClickListener(v -> {
            String name = editContactName.getText().toString();
            String phone = editContactPhone.getText().toString();
            String email = editContactEmail.getText().toString();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(v -> {
            Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
