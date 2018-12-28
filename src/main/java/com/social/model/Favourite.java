package com.social.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "favorite")
public class Favourite {
    private Long id;
    private Users favUser;
    private ZonedDateTime favTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Users getFavUser() {
        return favUser;
    }

    public void setFavUser(Users favUser) {
        this.favUser = favUser;
    }

    public ZonedDateTime getFavTime() {
        return favTime;
    }

    public void setFavTime(ZonedDateTime favTime) {
        this.favTime = favTime;
    }
}
