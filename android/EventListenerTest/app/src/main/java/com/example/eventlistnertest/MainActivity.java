package com.example.eventlistnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textView);
        text1.setText("첫 번째 TextView");

        Button button1 = findViewById(R.id.button);
        BtnOnClickListener listener = new BtnOnClickListener(); // 기본 방법
        button1.setOnClickListener(listener);

        Button button2 = findViewById(R.id.button2);
        View.OnClickListener listener2 = new View.OnClickListener() { // 익명클래스
            @Override
            public void onClick(View v) {
                text1.setText("Button2 is clicked!");
            }
        };
        button2.setOnClickListener(listener2);


    }

    public void onClick(View v) {
        text1.setText("Button3 is clicked");
    }

    class BtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            text1.setText("Button1 is clicked!");
        }
    }


}

