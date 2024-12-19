package com.service.music_circle_backend.entities.genre;

import com.service.music_circle_backend.entities.audio_file.AudioFile;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre{
    //Variables
    //@ApiModelProperty(notes = "Id of genre", name = "id", required = true, value = "test id")
    @ApiModelProperty(notes = "unique id of genre")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty(notes = "Name of genre", name = "name", required = true, value = "test name")
    @ApiModelProperty(notes = "Name of genre")
    private String name;
    //@ApiModelProperty(notes = "List of songs in genre", name = "audioFilesInfos", required = false, value = "test songs")
    @ApiModelProperty(notes = "List of songs in genre")
    @OneToMany(fetch = FetchType.LAZY)
    private List<AudioFile> songs;

    //Constructors
    protected Genre(){}
    public Genre(String name){
        this.name = name;
        this.songs = new ArrayList<AudioFile>();
    }

    //Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public List<AudioFile> getSongs(){ return songs; }

    //Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSongs(List<AudioFile> songs){ this.songs = songs; }

    //Methods
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Genre)){
            return false;
        }
        Genre genre = (Genre) o;
        if(this.name.equalsIgnoreCase(genre.name)){
            return true;
        }
        else{
            return false;
        }
    }
}

