package com.example.listviewtest4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    TextView editText_add;
    Button buttonAdd_add;
    String member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

//        Intent mainToAddIntent = getIntent();

        editText_add = findViewById(R.id.editText_add);
        buttonAdd_add = findViewById(R.id.buttonAdd_add);
        editText_add.setText("");


        buttonAdd_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member = editText_add.getText().toString();
                try {
                    Intent addToMainIntent = new Intent();
                    addToMainIntent.putExtra("member", member);
                    setResult(Activity.RESULT_OK, addToMainIntent);
                } catch (Exception e) {
                    setResult(Activity.RESULT_CANCELED);
                }
                editText_add.setText("");
                finish();
            }
        });
    }


}