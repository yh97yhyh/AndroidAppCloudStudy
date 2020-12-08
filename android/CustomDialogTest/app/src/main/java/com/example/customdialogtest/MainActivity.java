package com.example.customdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("타이틀 이름");
                builder.setIcon(R.mipmap.ic_launcher_round);
//                LayoutInflater inflater = getLayoutInflater();
//                View customView = inflater.inflate(R.layout.dialog_custom, null);
                builder.setView(R.layout.dialog_custom);
                DialogListener listener = new DialogListener();
                builder.setPositiveButton("Login", listener);
                builder.setNeutralButton("Cancel", listener);
                builder.show();
            }
        });
    }

    class DialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            AlertDialog alert = (AlertDialog) dialog;
            EditText editId = alert.findViewById(R.id.editTextId);
            EditText editPw = alert.findViewById(R.id.editTextPw);

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    String userId = editId.getText().toString();
                    String userPw = editPw.getText().toString();
                    textView.setText("ID: " + userId + ", " + "PW: " + userPw);
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    break;
            }
        }
    }
}