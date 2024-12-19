package com.service.music_circle_backend.entities.user;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "music_group")
@ApiModel(description = "Details about a group")
public class Group {
    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "unique id of the group")
    private Long id;
    @ApiModelProperty(notes = "group's name")
    private String name;
    @ApiModelProperty(notes = "group's description")
    private String description;
    @ElementCollection
    private List<String> members;
    @ManyToOne
    private User creatorUser;
    @ApiModelProperty(notes = "unique creator of group")
    private String creator;
     @Lob
    //@Column(name = "file", columnDefinition = "LONGBLOB")
    private String picFilename;

    //List of songs, playlists, albums, events


    public Group(Long id, String name, String description, String creator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    public Group(String name, String description, String creator){
        this.name = name;
        this.description = description;
        this.creator = creator;
    }
    public Group(String name, String description, User creator){
        this.name = name;
        this.description = description;
        this.creatorUser = creator;
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatorUser(User creatorUser){
        this.creatorUser = creatorUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getCreator() {
        return creator;
    }
    public User getCreatorUser(){
        return creatorUser;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public String getPicFilename() {
        return picFilename;
    }

    public void setPicFilename(String picFilename) {
        this.picFilename = picFilename;
    }

}


