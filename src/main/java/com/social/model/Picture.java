package com.social.model;


import com.social.enums.LifeCycle;
import com.social.enums.PictureKind;
import com.social.enums.PictureType;

import javax.persistence.*;

@Entity
@Table(name = "picture")
public class Picture {
    private Long id;
    private Users user;
    private PictureType type;
    private String picturePath;
    private PictureKind pictureKind;
    private LifeCycle lifecycle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public PictureType getType() {
        return type;
    }

    public void setType(PictureType type) {
        this.type = type;
    }

    public LifeCycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(LifeCycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public PictureKind getPictureKind() {
        return pictureKind;
    }

    public void setPictureKind(PictureKind pictureKind) {
        this.pictureKind = pictureKind;
    }
}
