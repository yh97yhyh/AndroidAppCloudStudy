package com.example.listviewtest4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button buttonDel;
    Button buttonAdd;
    Button buttonMultiDel;
    ArrayAdapter adapter;
    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    ArrayList<String> btsList;
    public static final int REQ_ADD = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        buttonDel = findViewById(R.id.buttonDel);
        buttonAdd = findViewById(R.id.bttonAdd);
        buttonMultiDel = findViewById(R.id.buttonMultiDel);

        btsList = new ArrayList<>();
        for (String name:bts) {
            btsList.add(name);
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked, btsList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        buttonMultiDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
                for (int i=btsList.size()-1; i>-1; i--) {
                    if (checkedItemPositions.get(i)) {
                        btsList.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
                listView.clearChoices();
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = listView.getCheckedItemPosition();
                if (pos != ListView.INVALID_POSITION) {
                    btsList.remove(pos);
                    adapter.notifyDataSetChanged();
                    listView.clearChoices();
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainToAddIntent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(mainToAddIntent, REQ_ADD);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ADD) {
            if (resultCode == Activity.RESULT_OK) {
                String member = data.getStringExtra("member");
                btsList.add(member);
                adapter.notifyDataSetChanged();
            }
        }
    }

}