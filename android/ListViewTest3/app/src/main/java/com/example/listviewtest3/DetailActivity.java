package com.example.listviewtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textNick;
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.image_detail);
        textNick = findViewById(R.id.text_nick_detail);
        textName = findViewById(R.id.text_name_detail);

        Intent intent = getIntent();
        String nick = intent.getStringExtra("nicks");
        String name = intent.getStringExtra("names");
        int image = intent.getIntExtra("images", 0);

        imageView.setImageResource(image);
        textNick.setText(nick);
        textName.setText(name);
    }
}