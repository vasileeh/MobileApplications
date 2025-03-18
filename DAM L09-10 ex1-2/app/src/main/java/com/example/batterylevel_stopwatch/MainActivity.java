package com.example.batterylevel_stopwatch;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BatteryReceiver batteryReceiver;
    private TextView timerText;
    private Button startPauseButton, resetButton;
    private Handler handler = new Handler();
    private boolean isRunning = false;
    private long startTime = 0, elapsedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryReceiver = new BatteryReceiver();
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));

        timerText = findViewById(R.id.timerText);
        startPauseButton = findViewById(R.id.startPauseButton);
        resetButton = findViewById(R.id.resetButton);

        startPauseButton.setOnClickListener(v -> {
            if (isRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        resetButton.setOnClickListener(v -> resetTimer());
    }

    private void startTimer() {
        startTime = System.currentTimeMillis() - elapsedTime;
        handler.postDelayed(updateTimer, 0);
        isRunning = true;
        startPauseButton.setText("Pauza");
    }

    private void pauseTimer() {
        handler.removeCallbacks(updateTimer);
        elapsedTime = System.currentTimeMillis() - startTime;
        isRunning = false;
        startPauseButton.setText("Start");
    }

    private void resetTimer() {
        handler.removeCallbacks(updateTimer);
        elapsedTime = 0;
        timerText.setText("00:00:00");
        isRunning = false;
        startPauseButton.setText("Start");
    }

    private Runnable updateTimer = new Runnable() {
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            long millis = now - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            int hours = minutes / 60;
            seconds %= 60;
            minutes %= 60;
            timerText.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
        handler.removeCallbacks(updateTimer);
    }
}
