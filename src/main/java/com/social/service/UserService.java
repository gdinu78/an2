package com.social.service;

import com.social.enums.RolEnum;
import com.social.model.Location;
import com.social.model.Picture;
import com.social.model.Roles;
import com.social.model.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void save(Users user);

    void save(Location location);

    void save(Picture picture);

//    List<Picture> listPictures();
//
//    Picture getFile(Long id);

    Users findByUsername(String username);

    Roles findByRoleName(RolEnum rolEnum);

    //List<Users> findAll(int fromRecordNo, int toRecordNo);

    List<Users> findAll();

    public Users findByUserID(UUID id);

    Location getClientLocation();

    String getClientIpAddr();
}
