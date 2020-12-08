package com.example.listdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonSingle;
    Button buttonDouble;
    String[] nicks = {"진", "슈가", "제이홉", "RM", "지민", "뷔", "정국"};
    String[] names = {"김석진", "민윤기", "정호석", "김남준", "박지민", "김태형", "전정국"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonSingle = findViewById(R.id.buttonSingle);
        buttonDouble = findViewById(R.id.buttonDouble);

        buttonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("BTS Members");
                builder.setNegativeButton("Cancel", null);
                builder.setItems(nicks, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("선택된 멤버는 " + nicks[which]);
                    }
                });
                builder.show();
            }
        });

        buttonDouble = findViewById(R.id.buttonDouble);
        buttonDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<HashMap<String, String>> members = new ArrayList<>();
                for(int i=0; i<nicks.length; i++) {
                    HashMap<String, String> member = new HashMap<>();
                    member.put("nick", nicks[i]);
                    member.put("name", names[i]);
                    members.add(member);
                }

                String[] from = {"nick", "name"};
                int[] to = {android.R.id.text1, android.R.id.text2};
                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, members, android.R.layout.simple_list_item_2, from, to);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("BTS Members");
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HashMap<String, String> member = (HashMap<String, String>) adapter.getItem(which);
                        String nick = member.get("nick");
                        String name = member.get("name");
                        textView.setText(nick + "의 이름은 " + name);
//                        textView.setText(nicks[which] + "의 이름은 " + names[which]);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("취소되었습니다.");
                    }
                });
                builder.show();
            }
        });
    }
}