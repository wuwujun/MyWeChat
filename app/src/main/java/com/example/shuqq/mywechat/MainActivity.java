package com.example.shuqq.mywechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String [] data = {"wuwujun", "lalala", "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG",
                                "HHH", "III", "JJJ", "KKK", "LLL", "MMM"};

    private List<Bean> peopleList = new ArrayList<>();
    PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPeople();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerOnItemClickListener(MainActivity.this, recyclerView,
                new RecyclerOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, activity_chat.class);
                if (peopleList.size() != 0) {
                    intent.putExtra("id", peopleList.get(position).getPortrait());
                    intent.putExtra("position", position);
                    startActivityForResult(intent, 1);
                }
                //startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                adapter.removeData(position);
                Toast.makeText(recyclerView.getContext(), "你删除了item" + position, Toast.LENGTH_SHORT).show();
            }


        }));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    int position = data.getIntExtra("position", 0);
                    peopleList.get(position).settMessage(returnedData); /////////////////
                    adapter.notifyItemChanged(position);
                    Log.d("MainActivity", returnedData);
                }
                break;
            default:
                break;
        }
    }

    private void initPeople() {
        for (int i = 0; i < 1; i++) {
            Bean p1 = new Bean("p1", R.drawable.picture1, "");
            peopleList.add(p1);
            Bean p2 = new Bean("p2", R.drawable.picture2, "");
            peopleList.add(p2);
            Bean p3 = new Bean("p3", R.drawable.picture3, "");
            peopleList.add(p3);
            Bean p4 = new Bean("p4", R.drawable.picture4, "");
            peopleList.add(p4);
            Bean p5 = new Bean("p5", R.drawable.picture5, "");
            peopleList.add(p5);
            /*Bean p6 = new Bean(data[6], R.drawable.picture1);
            peopleList.add(p6);
            Bean p7 = new Bean(data[7], R.drawable.picture2);
            peopleList.add(p7);
            Bean p8 = new Bean(data[8], R.drawable.picture3);
            peopleList.add(p8);
            Bean p9 = new Bean(data[9], R.drawable.picture4);
            peopleList.add(p9);*/

        }
    }
}
