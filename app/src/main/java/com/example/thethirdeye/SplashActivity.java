package com.example.thethirdeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hide the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hide the action bar (if it exists)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Start a new thread to handle the delay and navigation
        Thread td = new Thread() {
            public void run() {
                try {
                    // Sleep for 3000 milliseconds (3 seconds)
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Create an Intent to start the MainActivity
                    Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    // Finish the SplashActivity to prevent going back to it when pressing back button
                    finish();
                }
            }
        };
        // Start the thread
        td.start();
    }




}