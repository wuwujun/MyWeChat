package com.example.shuqq.mywechat;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Shuqq on 2017/7/14.
 */

/* public class PeopleAdapter extends ArrayAdapter<Bean> {
    private int portrait;
    public PeopleAdapter(Context context, int textViewResourceId, List<Bean> objects) {
        super(context, textViewResourceId, objects);
        portrait = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Bean bean = getItem(position);
        View view;
        ViewHolder viewholder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(portrait, parent, false);
            viewholder = new ViewHolder();
            viewholder.peopleImg = (ImageView) view.findViewById(R.id.img);
            viewholder.peopleName = (TextView) view.findViewById(R.id.name);
            view.setTag(viewholder);        // 将viewholder存在view中

        } else {
            view = convertView;
            viewholder = (ViewHolder) view.getTag();
        }

        ImageView peopleImg = (ImageView) view.findViewById(R.id.img);
        TextView peopleName = (TextView) view.findViewById(R.id.name);

        peopleImg.setImageResource(bean.getPortrait());
        peopleName.setText(bean.getName());
        // peopleMsg.setText(bean.gettMessage());
        // peopleTime.setText(bean);

        return view;
    }

    class ViewHolder {
        ImageView peopleImg;
        TextView peopleName;
    }


} */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<Bean> peopleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View peopleView;
        ImageView peopleImg;
        TextView peopleName;
        TextView peopleMsg;

        public ViewHolder(View view) {
            super(view);
            peopleView = view;
            peopleImg = (ImageView) view.findViewById(R.id.img);
            peopleName = (TextView) view.findViewById(R.id.name);
            peopleMsg = (TextView) view.findViewById(R.id.msg);
        }
    }

    public PeopleAdapter(List<Bean> objects) {
        peopleList = objects;
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_iem, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        /* holder.peopleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Bean people = peopleList.get(position);
                Toast.makeText(v.getContext(), "你点击了view" + people.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.peopleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Bean people = peopleList.get(position);
                Toast.makeText(v.getContext(), "你点击了image" + people.getPortrait(), Toast.LENGTH_SHORT).show();

            }
        }); */


        return holder;
    }

    public void removeData(int position) {
        peopleList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bean people = peopleList.get(position);
        holder.peopleImg.setImageResource(people.getPortrait());
        holder.peopleName.setText(people.getName());
        holder.peopleMsg.setText(people.gettMessage());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }



}
