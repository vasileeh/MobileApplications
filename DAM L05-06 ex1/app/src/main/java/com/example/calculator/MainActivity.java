package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private TextInputEditText textInputX, textInputY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        textInputX = findViewById(R.id.textInputX);
        textInputY = findViewById(R.id.textInputY);

        Button btnSum = findViewById(R.id.btnSum);
        Button btnDif = findViewById(R.id.btnDif);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);

        btnSum.setOnClickListener(v -> {
            double x = getInputValue(textInputX);
            double y = getInputValue(textInputY);
            double sum = x + y;
            textViewResult.setText(String.valueOf(sum));
        });

        btnDif.setOnClickListener(v -> {
            double x = getInputValue(textInputX);
            double y = getInputValue(textInputY);
            double dif = x - y;
            textViewResult.setText(String.valueOf(dif));
        });

        btnMul.setOnClickListener(v -> {
            double x = getInputValue(textInputX);
            double y = getInputValue(textInputY);
            double mul = x * y;
            textViewResult.setText(String.valueOf(mul));
        });

        btnDiv.setOnClickListener(v -> {
            double x = getInputValue(textInputX);
            double y = getInputValue(textInputY);
            if (y != 0) {
                double div = x / y;
                textViewResult.setText(String.valueOf(div));
            } else {
                textViewResult.setText("Eroare: Impartire la 0");
            }
        });
    }

    private double getInputValue(TextInputEditText input) {
        String text = input.getText().toString().trim();
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }
}
