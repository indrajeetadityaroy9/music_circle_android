package com.service.music_circle_backend.entities.socket;

import javax.persistence.*;
import java.util.List;

@Entity
public class NotificationResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private String channel_id;
    private String user_from_username;
    private String user_to_username;
    private String users_to_usernames;

    public NotificationResponse(){}

    public NotificationResponse(String channel_id, String text, String title, String user_from_username, String user_to_username, String users_to_usernames){
        this.channel_id = channel_id;
        this.text = text;
        this.title = title;
        this.user_from_username = user_from_username;
        this.user_to_username = user_to_username;
    }

    public NotificationResponse(NotificationResponse notificationResponse){
        this.user_to_username = notificationResponse.getUser_to_username();
        this.title = notificationResponse.getTitle();
        this.text = notificationResponse.getText();
        this.user_from_username = notificationResponse.getUser_from_username();
        this.channel_id = notificationResponse.getChannel_id();
        this.users_to_usernames = notificationResponse.getUsers_to_usernames();
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsers_to_usernames() {
        return users_to_usernames;
    }

    public void setUsers_to_usernames(String users_to_usernames) {
        this.users_to_usernames = users_to_usernames;
    }
}
