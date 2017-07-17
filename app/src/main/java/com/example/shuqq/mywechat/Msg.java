package com.example.shuqq.mywechat;

/**
 * Created by Shuqq on 2017/7/17.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;
    private int portrait;

    public Msg(String content, int type, int portrait) {
        this.content = content;
        this.type = type;
        this.portrait = portrait;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPortrait() {
        return portrait;
    }
    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

}
