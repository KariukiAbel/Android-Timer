package com.nabesh.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
Button start;
TextView hrs, min, sec;
int hr = 0;
int mins = 0;
int secs = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button);
        start.setText("Start");
        start.setOnClickListener(startButtonListener);
    }

    public View.OnClickListener startButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hrs = findViewById(R.id.textView);
            hrs.setText(Integer.toString(hr));
            min = findViewById(R.id.textView2);
            min.setText(mins + "");
            sec = findViewById(R.id.textView3);
            sec.setText(secs + "");

            while (true){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                secs++;
                if (secs == 60){
                    mins++;
                    if (mins == 60){
                        hr++;
                        mins = 0;
                    }
                    secs = 0;
                }
            }

        }
    };
}
