package com.example.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView editText;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextMain);
        text = findViewById(R.id.textMain);
        button = findViewById(R.id.buttonMain);
        editText.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subIntent = new Intent(getApplicationContext(), SubActivity.class);
//                subIntent.putExtra("num1", 123);
//                subIntent.putExtra("num2", 456);
                String inputText = editText.getText().toString();
                subIntent.putExtra("str", inputText);
                startActivityForResult(subIntent, 101);
                editText.setText("");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101) {
            if(resultCode == Activity.RESULT_OK) {
//                int sum = data.getIntExtra("sum", 0);
//                text.setText(sum);
                String result = data.getStringExtra("str");
                text.setText(result);
            }
        }
    }
}