package com.example.btscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textNick;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent mainToDetailIntent = getIntent();
        BTS member = (BTS) mainToDetailIntent.getSerializableExtra("member");

        imageView = findViewById(R.id.image_detail);
        textNick = findViewById(R.id.textNick_detail);
        textName = findViewById(R.id.textName_detail);

        imageView.setImageResource(member.image);
        textNick.setText(member.nick);
        textName.setText(member.name);

    }
}