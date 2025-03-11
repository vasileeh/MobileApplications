package com.example.activitiesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button backBtn = findViewById(R.id.backBtn);
        ImageView imageView = findViewById(R.id.imageView);
        TextView description = findViewById(R.id.description);

        imageView.setImageResource(R.drawable.treird);
        description.setText("Aceasta este a treia activitate");

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}