package com.example.activitiesapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button nextBtn = findViewById(R.id.nextBtn);
        Button backBtn = findViewById(R.id.backBtn);
        ImageView imageView = findViewById(R.id.imageView);
        TextView description = findViewById(R.id.description);

        imageView.setImageResource(R.drawable.doind);
        description.setText("Aceasta este a doua activitate");

        nextBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}