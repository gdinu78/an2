package com.social.model;

import com.social.enums.RolEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Roles {
    private int id;
    private RolEnum roleName;
    private Set<Users> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RolEnum roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}
