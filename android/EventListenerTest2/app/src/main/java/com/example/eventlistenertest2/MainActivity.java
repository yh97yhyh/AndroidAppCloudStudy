package com.example.eventlistenertest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        Switch switch1 = findViewById(R.id.switch1);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        CheckBox checkBox = findViewById(R.id.checkBox);
        SearchView searchView = findViewById(R.id.searchView);

    }
}