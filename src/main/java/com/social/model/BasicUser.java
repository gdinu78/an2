package com.social.model;

import com.social.enums.Gender;
import com.social.enums.LifeCycle;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class BasicUser {
    private int userID;
    @Column(nullable = false)
    @NotNull
    @Email
    private String username;
    @Column(nullable = false)
    @NotNull
    @Size(min = 4, max = 30)
    private String name;
    @Column(nullable = false)
    @NotNull
    @Size(min = 6, max = 100)
    private String password;
    @Column(nullable = false)
    @NotNull
    @Size(min = 6, max = 100)
    private String passwordConfirm;
    @Column(nullable = false)
    @NotNull
    private boolean agreedTerms;
    @Column(nullable = false)
    @NotNull
    private Gender gender;
    @Column(nullable = false)
    private Set<Roles> roles;
    @Column(nullable = false)
    private LifeCycle lifecycle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isAgreedTerms() {
        return agreedTerms;
    }

    public void setAgreedTerms(boolean agreedTerms) {
        this.agreedTerms = agreedTerms;
    }

    public LifeCycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(LifeCycle lifecycle) {
        this.lifecycle = lifecycle;
    }
}
