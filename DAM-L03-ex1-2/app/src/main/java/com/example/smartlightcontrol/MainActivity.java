package com.example.smartlightcontrol;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private boolean LightOn = false;
    private boolean AutoMode = false;
    private TextView textView;
    private ConstraintLayout constraintLayout;
    private static final String CHANNEL_ID = "smart_light_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        constraintLayout = findViewById(R.id.constraintLayout);
        Button buttonOnOff = findViewById(R.id.buttonOnOff);
        Button buttonAuto = findViewById(R.id.buttonAuto);
        Button buttonChangeColor = findViewById(R.id.buttonChangeColor);

        buttonOnOff.setOnClickListener(v -> toggleLight());
        buttonAuto.setOnClickListener(v -> {
            AutoMode = !AutoMode;
            buttonAuto.setText(AutoMode ? "Disable Auto Mode" : "Enable Auto Mode");
            if (AutoMode) {
                updateLightBasedOnTime();
            }
        });
        buttonChangeColor.setOnClickListener(v -> changeLightColor());
    }

    private void toggleLight() {
        LightOn = !LightOn;
        updateUI();
    }

    private void updateUI() {
        if (LightOn) {
            constraintLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            textView.setText("Light is ON");
        } else {
            constraintLayout.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            textView.setText("Light is OFF");
        }
    }

    private void updateLightBasedOnTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 7 && hour < 18) {
            constraintLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
            LightOn = true;
            showNotification("Good morning! Do you need more light?");
        } else
            if (hour >= 18 && hour < 22) {
                constraintLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                LightOn = true;
        } else {
            constraintLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
            LightOn = false;
            showNotification("Good night! The light has turned off automatically.");
        }
        updateUI();
    }

    private void changeLightColor() {
        int[] colors = {android.R.color.holo_blue_bright, android.R.color.holo_red_light, android.R.color.holo_green_light};
        int randomColor = colors[(int) (Math.random() * colors.length)];
        constraintLayout.setBackgroundColor(getResources().getColor(randomColor));

        String colorMessage = "";

        if (randomColor == android.R.color.holo_blue_bright) {
            colorMessage = "The light has changed to Blue for relaxation";
        } else
            if (randomColor == android.R.color.holo_red_light) {
            colorMessage = "the light has changed to Red for alert mode";
        } else
            if (randomColor == android.R.color.holo_green_light) {
            colorMessage = "the light has changed to Green for focus";
        }

        showNotification(colorMessage);
    }

    private void showNotification(final String text) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }, 500);
    }
}
