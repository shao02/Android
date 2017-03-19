package com.example.hello.design_material.domain;

/**
 * Created by xu_s on 3/16/17.
 */

public class BroadcastMsg {
    private String broadcast_content;
    private String broadcast_dateTime;
    private String userName;
    private String profile_image;


    public BroadcastMsg(String broadcast_content, String broadcast_dateTime, String userName, String profile_image) {
        this.broadcast_content = broadcast_content;
        this.broadcast_dateTime = broadcast_dateTime;
        this.userName = userName;
        this.profile_image = profile_image;
    }


    public String getBroadcast_content() {
        return broadcast_content;
    }

    public void setBroadcast_content(String broadcast_content) {
        this.broadcast_content = broadcast_content;
    }

    public String getBroadcast_dateTime() {
        return broadcast_dateTime;
    }

    public void setBroadcast_dateTime(String broadcast_dateTime) {
        this.broadcast_dateTime = broadcast_dateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
