package com.service.music_circle_backend.entities.comment;

import com.service.music_circle_backend.entities.audio_file.AudioFile;
import com.service.music_circle_backend.entities.user.User;

import javax.persistence.*;

@Entity
public class Comment {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @OneToOne
    private User commenter;
    @ManyToOne
    private AudioFile song;

    //Constructor
    protected Comment() {}
    public Comment(String text, User commenter, AudioFile song) {
        this.text = text;
        this.commenter = commenter;
        this.song = song;
    }

    //Get Methods
    public Long getId() { return id; }
    public String getText() { return text; }
    public User getCommenter() { return commenter; }
    public AudioFile getSong(){ return song; }

    //Set Methods
    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setCommenter(User commenter) { this.commenter = commenter; }
    public void setSong(AudioFile song){ this.song = song; }
}


