package com.example.shuqq.mywechat;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Shuqq on 2017/7/18.
 */

public class Tab1 extends Fragment {
    private String [] data = {"wuwujun", "lalala", "AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG",
            "HHH", "III", "JJJ", "KKK", "LLL", "MMM"};

    private List<Bean> peopleList = new ArrayList<>();
    private PeopleAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        initPeople();

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerOnItemClickListener(getActivity(), recyclerView,
                new RecyclerOnItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), activity_chat.class);
                        if (peopleList.size() != 0) {
                            intent.putExtra("id", peopleList.get(position).getPortrait());
                            intent.putExtra("position", position);
                            startActivityForResult(intent, 1);
                        }
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        adapter.removeData(position);
                        Toast.makeText(recyclerView.getContext(), "你删除了item" + position, Toast.LENGTH_SHORT).show();
                    }


                }));

        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    int position = data.getIntExtra("position", 0);
                    peopleList.get(position).settMessage(returnedData); /////////////////
                    adapter.notifyItemChanged(position);
                    Log.d("WholeActivity", returnedData);
                }
                break;
            default:
                break;
        }
    }

    private void initPeople() {
        for (int i = 0; i < 2; i++) {
            Bean p1 = new Bean(data[1], R.drawable.picture1, "");
            peopleList.add(p1);
            Bean p2 = new Bean(data[2], R.drawable.picture2, "");
            peopleList.add(p2);
            Bean p3 = new Bean(data[3], R.drawable.picture3, "");
            peopleList.add(p3);
            Bean p4 = new Bean(data[4], R.drawable.picture4, "");
            peopleList.add(p4);
            Bean p5 = new Bean(data[5], R.drawable.picture5, "");
            peopleList.add(p5);
            Bean p6 = new Bean(data[6], R.drawable.picture1, "");
            peopleList.add(p6);
            Bean p7 = new Bean(data[7], R.drawable.picture2, "");
            peopleList.add(p7);
            Bean p8 = new Bean(data[8], R.drawable.picture3, "");
            peopleList.add(p8);
            Bean p9 = new Bean(data[9], R.drawable.picture4, "");
            peopleList.add(p9);

        }
    }
}
