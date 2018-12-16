package com.social.model;

import com.social.enums.LifeCycle;
import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "logins")
public class Logins {
    private Long id;
    private Users user_login;
    private ZonedDateTime loginTime;
    private String loginLocation;
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
    public Users getUser_login() {
        return user_login;
    }

    public void setUser_login(Users user_login) {
        this.user_login = user_login;
    }

    public ZonedDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(ZonedDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public LifeCycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(LifeCycle lifecycle) {
        this.lifecycle = lifecycle;
    }
}
