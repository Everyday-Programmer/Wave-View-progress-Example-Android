package com.example.waveviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.Timer;
import java.util.TimerTask;

import cjh.WaveProgressBarlibrary.WaveProgressBar;

public class MainActivity extends AppCompatActivity {
    int progress = 0;
    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WaveProgressBar waveProgressBar = findViewById(R.id.waveProgressbar);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (started) {
                    progress++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            waveProgressBar.setProgress(progress);
                        }
                    });

                    if (progress == 100) {
                        progress = 0;
                    }
                }
            }
        };

        timer.schedule(timerTask, 0, 80);

        waveProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                started = !started;
            }
        });
    }
}