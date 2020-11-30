package com.example.imageviewer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textName;
    ImageView imageView;
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    String[] names = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    int index = 0;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textName);
        imageView = findViewById(R.id.imageView);
        display();

        NextBtnOnClickListener nextBtnOnClickListener = new NextBtnOnClickListener();
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(nextBtnOnClickListener);
        button2.setOnClickListener(nextBtnOnClickListener);
        button.setEnabled(false);

    }

    private void display() {
        textName.setText(names[index]);
        imageView.setImageResource(images[index]);
    }

    class NextBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            button.setEnabled(true);
            button2.setEnabled(true);

            if (v.getId() == R.id.button) {
                index --;
                if (index <= 0) {
                    button.setEnabled(false);
                }
            }
            else if (v.getId() == R.id.button2) {
                index ++;
                if (index >= images.length-1) {
                    button2.setEnabled(false);

                }
            }
            display();
        }

    }
}