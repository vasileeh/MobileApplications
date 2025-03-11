package com.example.phonebookapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView contactName, contactPhone, contactEmail;
    private Button callButton, emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        contactName = findViewById(R.id.contactName);
        contactPhone = findViewById(R.id.contactPhone);
        contactEmail = findViewById(R.id.contactEmail);
        callButton = findViewById(R.id.callButton);
        emailButton = findViewById(R.id.emailButton);

        String name = getIntent().getStringExtra("contactName");
        contactName.setText(name);

        contactPhone.setText("Phone: 0745663412");
        contactEmail.setText("Email: abc@email.com");

        callButton.setOnClickListener(v -> {
            Uri phoneUri = Uri.parse("tel:0745663412");
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, phoneUri);
            startActivity(dialIntent);
        });

        emailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:abc@mail.com"));
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });
    }
}
