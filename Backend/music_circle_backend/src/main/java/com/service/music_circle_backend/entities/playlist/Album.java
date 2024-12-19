package com.service.music_circle_backend.entities.playlist;

import com.service.music_circle_backend.entities.audio_file.AudioFile;
import com.service.music_circle_backend.entities.user.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    //Variables
    //@ApiModelProperty(notes = "Id of album", name = "id", required = true, value = "test id")
    @ApiModelProperty(notes = "unique id of album")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty(notes = "Name of album", name = "albumName", required = true, value = "test albumName")
    @ApiModelProperty(notes = "Name of album")
    private String albumName;
    private String artist;
//    @ApiModelProperty(notes = "Name of artist")
//    private String artist;
    @ApiModelProperty(notes = "Boolean value if album contains only one song")
    private boolean single;
    private String albumPicFilename;
    @OneToMany(fetch = FetchType.LAZY)
    private List<AudioFile> songs;

    //Constructors
    protected Album(){}
        public Album(String albumName, String artist_username, List<AudioFile> songs){
        this.albumName = albumName;
        this.artist = artist_username;
        this.songs = songs;
        this.single = false;
    }
    public Album(String albumName, String artist_username){
        this.albumName = albumName;
        this.artist = artist_username;
        this.single = false;
    }
    public Album(String albumName, String artist_username, AudioFile song){
        this.albumName = albumName;
        this.artist = artist_username;
        this.songs = new ArrayList<AudioFile>();
        this.songs.add(song);
        this.single = true;
    }



    //Getters
    public String getAlbumName() { return albumName; }
    public String getArtist() { return artist; }
    public Long getId() { return id; }
    public List<AudioFile> getTracklist() { return songs; }
    public boolean isSingle() { return (single && songs.size() < 2); }

    public String getAlbumPicFilename() {
        return albumPicFilename;
    }

    //Setters
    public void setAlbumName(String albumName) { this.albumName = albumName; }
    public void setArtist(String artist_username) { this.artist = artist_username; }
    public void setId(Long id) { this.id = id; }
    public void setTracklist(List<AudioFile> songs) { this.songs = songs; }
    public void setSingle(boolean single) { this.single = single; }

    public void setAlbumPicFilename(String albumPicFilename) {
        this.albumPicFilename = albumPicFilename;
    }
}

