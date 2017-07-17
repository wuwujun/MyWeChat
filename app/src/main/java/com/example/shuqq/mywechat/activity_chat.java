package com.example.shuqq.mywechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class activity_chat extends AppCompatActivity {

    private List<Msg> mMsgList = new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRcv;

    private MsgAdapter adapter;

    // private ImageView leftImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 1);
        final int position = intent.getIntExtra("position", 0);
        Log.d("activity_chat", String.valueOf(id));
        Log.d("activity_chat", String.valueOf(position));

        initMsg();

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRcv = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRcv.setLayoutManager(layoutManager);

        for (int i = 0; i < mMsgList.size(); i++) {
            if (mMsgList.get(i).getType() == Msg.TYPE_RECEIVED) {
                mMsgList.get(i).setPortrait(id);
            }
        }

        adapter = new MsgAdapter(mMsgList);

        msgRcv.setAdapter(adapter);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT, R.drawable.picture2);
                    mMsgList.add(msg);
                    adapter.notifyItemInserted(mMsgList.size() - 1);
                    msgRcv.scrollToPosition(mMsgList.size() - 1);
                    inputText.setText("");
                    Intent intent = new Intent();
                    intent.putExtra("data_return", content);
                    intent.putExtra("position", position);
                    setResult(RESULT_OK, intent);
                   // finish();
                }
            }
        });


    }

    private void initMsg() {
        Msg msg1 = new Msg("hello, how are you?", Msg.TYPE_RECEIVED, R.drawable.picture1);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("I'm fine, thank you!", Msg.TYPE_SENT, R.drawable.picture2);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("XDDDDDDDDDDD", Msg.TYPE_RECEIVED, R.drawable.picture1);
        mMsgList.add(msg3);
    }
}
