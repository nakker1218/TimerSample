package me.nakker.timersample;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public long COUNT_TIME = 10 * 60 * 1000;
    public long COUNT_INTERVAL = 1000;

    public CountDownTimer countDownTimer;
    public SimpleDateFormat dataFormat = new SimpleDateFormat("mm:ss", Locale.JAPAN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView timerText = findViewById(R.id.timer_text);
        timerText.setText(dataFormat.format(COUNT_TIME));

        countDownTimer = new CountDownTimer(COUNT_TIME, COUNT_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                // 1秒ごとに呼び出される
                timerText.setText(dataFormat.format(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                // 終わった時に呼び出される
                timerText.setText(dataFormat.format(0));
            }
        };
    }

    public void start(View v) {
        countDownTimer.start();
    }

    public void stop(View v) {
        countDownTimer.cancel();
    }
}
