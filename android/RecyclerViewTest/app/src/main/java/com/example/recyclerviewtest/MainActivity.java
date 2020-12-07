package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] nicks = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ArrayList<BTS> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        members = new ArrayList<>();
        for(int i=0; i<nicks.length; i++) {
            BTS member = new BTS(nicks[i], names[i], images[i]);
            members.add(member);
        }

        RecyclerView recycler;
        recycler = findViewById(R.id.recycler);

        BTSAdapter adapter = new BTSAdapter(this, members, R.layout.layout_item);
        recycler.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler.setLayoutManager(manager);

//        GridLayoutManager manager1 = new GridLayoutManager(this, 2);
//        recycler.setLayoutManager((manager1));

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        DividerItemDecoration decoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(decoration);
        recycler.addItemDecoration(decoration1);

    }
}