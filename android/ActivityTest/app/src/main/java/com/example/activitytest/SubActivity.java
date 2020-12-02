package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    TextView editText;
    TextView text;
    Button button;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
//        int num1 = subIntent.getIntExtra("num1", 0);
//        int num2 = subIntent.getIntExtra("num2", 0);
//        sum = num1 + num2;
        String str = intent.getStringExtra("str");

        editText = findViewById(R.id.editTextSub);
        text = findViewById(R.id.textSub);
        button = findViewById(R.id.buttonSub);

        text.setText(str);
        editText.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                String resultText = editText.getText().toString();
                intent1.putExtra("str", resultText);
                setResult(Activity.RESULT_OK, intent1);
                editText.setText("");
                finish();
            }
        });

    }
}