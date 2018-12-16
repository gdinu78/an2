package com.social.model;

import com.social.enums.Gender;
import com.social.enums.LifeCycle;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    private int userID;
    private UsersDetails userDetails;
    private UsersDetails supplierDetails;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String passwordConfirm;
    @Column(nullable = false)
    private boolean agreedTerms;
    @Column(nullable = false)
    private Gender gender;
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

    @OneToOne(mappedBy = "user")
    public UsersDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UsersDetails userDetails) {
        this.userDetails = userDetails;
    }

    @OneToOne(mappedBy = "user")
    public UsersDetails getSupplierDetails() {
        return supplierDetails;
    }

    public void setSupplierDetails(UsersDetails supplierDetails) {
        this.supplierDetails = supplierDetails;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
