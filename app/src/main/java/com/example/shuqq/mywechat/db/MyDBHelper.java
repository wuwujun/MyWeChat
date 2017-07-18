package com.example.shuqq.mywechat.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Shuqq on 2017/7/18.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String CREATE_PEOPLE = "create table people ("
            + "id integer primary key autoincrement, "
            + "portrait integer, "
            + "tMsg text, "
            + "name text)";

    private Context mContext;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PEOPLE);
        Toast.makeText(mContext, "Cretae succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
