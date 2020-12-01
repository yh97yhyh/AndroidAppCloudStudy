package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bts);
        listView.setAdapter(adapter);
//        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        };
        ItemClickListener listener = new ItemClickListener();
        listView.setOnItemClickListener(listener);

    }
    class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // ListView, ItemView, 몇번째 item
            System.out.println(bts[position]);

//            Toast toast = Toast.makeText(MainActivity.this, bts[position], Toast.LENGTH_SHORT);
//            toast.show();
            Toast.makeText(MainActivity.this, bts[position], Toast.LENGTH_SHORT).show();
        }
    }
}