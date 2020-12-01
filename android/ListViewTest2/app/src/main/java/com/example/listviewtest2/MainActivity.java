package com.example.listviewtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class MainActivity extends AppCompatActivity {

    String[] bts = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    ListView listView;
    ArrayList<HashMap<String, String>> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList<HashMap<String, String>>
        members = new ArrayList<>();
        for(int i=0; i<bts.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("nick", bts[i]);
            map.put("name", names[i]);
            members.add(map);
        }

        String[] keys = {"nick", "name"};
        int[] ids = {android.R.id.text1, android.R.id.text2};
        listView = findViewById(R.id.listview);
        SimpleAdapter adapter = new SimpleAdapter(this, members, android.R.layout.simple_list_item_2, keys, ids);
        ItemClickListener itemClickListener = new ItemClickListener();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);

    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this, members.get(position).get("nick"), Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, members.get(position).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}