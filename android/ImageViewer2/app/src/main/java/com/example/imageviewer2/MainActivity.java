package com.example.imageviewer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNum;
    TextView textName;
    ImageView imageView;
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    String[] names = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    int index = 0;
    Button button;
    Button button2;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI(); // UI 참조값 초기화
        listenerBtn(); // Button 리스너
        listenerSeekBar(); // SeekBar 리스너

        display();

    }

    private void listenerSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                index = progress;
                setIndex(index);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void listenerBtn() {
        NextBtnOnClickListener nextBtnOnClickListener = new NextBtnOnClickListener();
        button.setOnClickListener(nextBtnOnClickListener);
        button2.setOnClickListener(nextBtnOnClickListener);
        button.setEnabled(false);
    }

    private void initUI() {
        textNum = findViewById(R.id.textNum);
        textName = findViewById(R.id.textName);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        seekBar = findViewById(R.id.seekBar);
    }

    private void display() {
        textNum.setText(String.format("%d / %d", index+1, names.length));
        textName.setText(names[index]);
        imageView.setImageResource(images[index]);
        seekBar.setProgress(index);
    }

    class NextBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.button) {
                index --;
            }
            else if (v.getId() == R.id.button2) {
                index ++;
            }
            setIndex(index);
        }

    }

    void setIndex(int i) {
        button.setEnabled(true);
        button2.setEnabled(true);

        if (i <= 0) {
            button.setEnabled(false);
        }
        if (i >= images.length-1) {
            button2.setEnabled(false);
        }
        display();
    }

}