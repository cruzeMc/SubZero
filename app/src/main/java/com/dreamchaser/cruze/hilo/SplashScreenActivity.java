package com.dreamchaser.cruze.hilo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class SplashScreenActivity extends AppCompatActivity {
    private boolean isRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        isRunning = true;

        startSplash();

    }

    private void startSplash() {

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            doFinish();
                        }
                    });
                }
            }
        }).start();
    }

    private synchronized void doFinish() {
        if (isRunning)	{
            isRunning = false;
            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            isRunning = false;
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
