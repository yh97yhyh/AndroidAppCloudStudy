package com.example.simpledialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonSimple = findViewById(R.id.buttonSimple);

        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("다이얼로그 타이틀");
                builder.setMessage("다이얼로그 메시지");
                builder.setIcon(R.mipmap.ic_launcher);
                SimpleDialogListener listener = new SimpleDialogListener();
                builder.setPositiveButton("예", listener);
                builder.setNegativeButton("아니오", listener);
                builder.setNeutralButton("보류", listener);
                builder.show();
            }
        });
    }

    class SimpleDialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    textView.setText("예가 눌러짐.");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    textView.setText("아니오가 눌러짐.");
                    break;
                case  DialogInterface.BUTTON_NEUTRAL:
                    textView.setText("보류가 눌러짐.");
                    break;
            }
        }
    }
}