package com.service.music_circle_backend.entities.audio_file;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.music_circle_backend.entities.genre.Genre;
import com.service.music_circle_backend.entities.playlist.Album;
import com.service.music_circle_backend.entities.user.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "audio_file")
public class AudioFile{
    //Variables
    @ApiModelProperty(notes = "unique id of audio file")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ApiModelProperty(notes = "File name of mp3 file")
    private String filename;
    @ApiModelProperty(notes = "User who uploaded song")
    //@OneToOne(fetch = FetchType.LAZY)
    private String artist;

    private String artistName;
    @ApiModelProperty(notes = "Album song belongs to")
    @ManyToOne
    private Album album;
    @ApiModelProperty(notes = "Name of song")
    private String songName;
    @ApiModelProperty(notes = "Genre of song")
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
    @ApiModelProperty(notes = "Number of likes for song")
    private int likes;
    @ApiModelProperty(notes = "Number of plays for song")
    private int plays;
    @ApiModelProperty(notes = "Boolean if song is can be listened to by public")
    private boolean isPublic;
    @Lob
    @ApiModelProperty(notes = "Artwork for song")
    private String songPicFilename;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(notes = "Date and time song was uploaded")
    private LocalDateTime uploadDate;



    //Constructors
    protected AudioFile(){}
    public AudioFile(String filename){
        this.filename = filename;
        uploadDate = LocalDateTime.now();
    }
    public AudioFile(String filename, String songName, User artist) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }
    public AudioFile(String filename, String songName, User artist, String songPicFilename) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        this.songPicFilename = songPicFilename;
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }
    public AudioFile(String filename, String songName, User artist, Album album) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        this.album = album;
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }
    public AudioFile(String filename, String songName, User artist, Genre genre) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        this.genre = genre;
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }
    public AudioFile(String filename, String songName, User artist, Genre genre, String songPicFilename) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        this.genre = genre;
        this.songPicFilename = songPicFilename;
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }
    public AudioFile(String filename, String songName, User artist, Album album, Genre genre) throws IOException {
        this.filename = filename;
        this.songName = songName;
        this.artist = artist.getUsername();
        this.album = album;
        this.genre = genre;
        uploadDate = LocalDateTime.now();
        isPublic = true;
        likes = 0;
        plays = 0;
    }

    //Logging
    @Override
    public String toString(){
        return String.format(
                "AudioFile[ID: %d, FILENAME: '%s']",
                id, filename
        );
    }

    //Getters
    public Long getId(){ return id; }
    public String getFilename(){ return filename; }
    public String getArtist() { return artist; }
    public Album getAlbum() { return album; }
    public String getSongName() { return songName; }
    public Genre getGenre() { return genre; }
    public int getLikes() { return likes; }
    public int getPlays() { return plays; }
    public boolean isPublic() { return isPublic; }
    public String getSongPicFilename(){ return songPicFilename; }
    public LocalDateTime getUploadDate() { return uploadDate; }

    public String getArtistName() {
        return artistName;
    }


    public int getTopCounter() {
        return plays + likes;
    }

    //Setters

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setFilename(String filename) { this.filename = filename; }
    public void setId(Long id){ this.id = id; }
    public void setSongPicFilename(String songPicFilename) { this.songPicFilename = songPicFilename; }
    public void setArtist(User artist) { this.artist = artist.getUsername(); }
    public void setAlbum(Album album) { this.album = album; }
    public void setSongName(String songName) { this.songName = songName; }
    public void setGenre(Genre genre) { this.genre = genre; }
    public void setLikes(int likes) { this.likes = likes; }
    public void setPlays(int plays) { this.plays = plays; }
    public void setPublic(boolean aPublic) { isPublic = aPublic; }
    public void addLikes(){ likes++; }
    public void decreaseLikes(){ likes--; }
    public void addPlays(){ plays++; }
    public void decreasePlays(){ plays--; }
    public void setUploadDate(LocalDateTime uploadDate) { this.uploadDate = uploadDate; }

    //Methods
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof AudioFile)){
            return false;
        }
        AudioFile audioFile = (AudioFile) o;
        return Objects.equals(this.id, audioFile.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.filename, this.toString());
    }

}
