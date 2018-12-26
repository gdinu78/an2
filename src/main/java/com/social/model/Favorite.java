package com.social.model;

import com.social.enums.FavEnum;
import com.social.enums.LifeCycle;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "favorite")
public class Favorite {
    private Long id;
    private Users favUser;
    private FavEnum favorite;
    private ZonedDateTime favTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FavEnum getFavorite() {
        return favorite;
    }

    public void setFavorite(FavEnum favorite) {
        this.favorite = favorite;
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
