package com.example.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView receivedMessage;
    EditText replyInput;
    Button replyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        receivedMessage = findViewById(R.id.receivedMessage);
        replyInput = findViewById(R.id.replyInput);
        replyButton = findViewById(R.id.replyButton);

        Intent intent = getIntent();
        if (intent.hasExtra("message")) {
            String message = intent.getStringExtra("message");
            receivedMessage.setText("Received: " + message);
        }

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reply = replyInput.getText().toString();
                Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
                replyIntent.putExtra("message", reply);
                startActivity(replyIntent);
            }
        });
    }
}