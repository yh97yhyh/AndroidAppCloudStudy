package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(btnOnClickListener);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(btnOnClickListener);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(btnOnClickListener);

        Switch switch1 = findViewById(R.id.switch1);
    }

    class BtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.button) {
                textView.setText("Button1 is clicked!");
            }
            else if (id == R.id.button2) {
                textView.setText("Button2 is clicked!");
            }
            else if (id == R.id.button3) {
                textView.setText("Button3 is clicked!");
            }
        }
    }
}