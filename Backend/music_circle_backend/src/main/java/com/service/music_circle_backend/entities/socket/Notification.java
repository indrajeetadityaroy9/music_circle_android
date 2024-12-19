package com.service.music_circle_backend.entities.socket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Notification {
    private String title;
    private String text;
    private String channel_id;
    private String user_from_username;
    private String user_to_username;


    public Notification(){}

    public String getText() {
        return text;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public String getTitle() {
        return title;
    }

    public String getUser_from_username() {
        return user_from_username;
    }

    public String getUser_to_username() {
        return user_to_username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser_from_username(String user_from_username) {
        this.user_from_username = user_from_username;
    }

    public void setUser_to_username(String user_to_username) {
        this.user_to_username = user_to_username;
    }

}
