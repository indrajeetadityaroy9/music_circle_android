package com.service.music_circle_backend.entities.playlist;

import com.service.music_circle_backend.entities.audio_file.AudioFile;
import com.service.music_circle_backend.entities.audio_file.AudioFile;
import com.service.music_circle_backend.entities.user.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Playlist {
    //Variables
    //@ApiModelProperty(notes = "Id of playlist", name = "id", required = true, value = "test id")
    @ApiModelProperty(notes = "unique id of album")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty(notes = "Name of playlist", name = "name", required = true, value = "test name")
    @ApiModelProperty(notes = "Name of playlist")
    private String name;
    //@ApiModelProperty(notes = "User who created playlist", name = "creatorUsername", required = true, value = "test creatorUsername")
    @ApiModelProperty(notes = "User who created playlist")
    private String creatorUsername;
    //@ApiModelProperty(notes = "List of people able to listen to playlist", name = "listeners", required = false, value = "test listeners")
    @ApiModelProperty(notes = "List of people able to listen to playlist")
    @ElementCollection
    List<String> listeners;
    //@ApiModelProperty(notes = "List of songs in playlist", name = "songs", required = false, value = "test songs")
    @ApiModelProperty(notes = "List of songs in playlist")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<AudioFile> songs;

    //Constructors
    protected Playlist(){}
    public Playlist(String name, String creatorUsername){
        this.name = name;
        this.creatorUsername = creatorUsername;
        this.songs = new ArrayList<AudioFile>();
        this.listeners = new ArrayList<String>();
        listeners.add(creatorUsername);
    }
    public Playlist(String name, String creatorUsername, AudioFile song){
        this.name = name;
        this.creatorUsername = creatorUsername;
        this.songs = new ArrayList<AudioFile>();
        this.songs.add(song);
        this.listeners = new ArrayList<String>();
        listeners.add(creatorUsername);
    }
    public Playlist(String name, String creatorUsername, List<AudioFile> songs){
        this.name = name;
        this.creatorUsername = creatorUsername;
        this.songs = songs;
        this.listeners = new ArrayList<String>();
        listeners.add(creatorUsername);
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public String getcreatorUsername(){
        return creatorUsername;
    }
    public Long getId(){ return id; }
    public List<AudioFile> getSongs() { return songs; }
    public List<String> getListeners() { return listeners; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setcreatorUsername(String creatorUsername) { this.creatorUsername = creatorUsername; }
    public void setListeners(List<String> listeners) { this.listeners = listeners; }
    public void setId(Long id){ this.id = id; }
    public void setSongs(List<AudioFile> songs) { this.songs = songs; }

    @Override
    public String toString(){
        return "Playlist: " + name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Playlist)){
            return false;
        }
        Playlist playlist = (Playlist) o;
        return Objects.equals(this.name, playlist.name);
    }

}
