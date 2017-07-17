package com.example.shuqq.mywechat;

/**
 * Created by Shuqq on 2017/7/14.
 */

public class Bean {
    private String tMessage;
    private Integer portrait;
    // private String time;
    // private int id;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /* public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    } */
    public String gettMessage() {
        return tMessage;
    }
    public void settMessage(String tMessage) {
        this.tMessage = tMessage;
    }
    public Integer getPortrait() {
        return portrait;
    }
    public void setPortrait(Integer portrait) {
        this.portrait = portrait;
    }

    /*public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }*/
    public Bean(String name, Integer portrait, String tMessage) {
        super();
        this.tMessage = tMessage;
        this.portrait = portrait;
        /*this.time = time;
        this.id = id;*/
        this.name = name;
    }
    public Bean() {
        super();
    }

}
