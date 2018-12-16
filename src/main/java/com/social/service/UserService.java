package com.social.service;

import com.social.model.Location;
import com.social.model.Picture;
import com.social.model.Users;

import java.util.List;

public interface UserService {
    void save(Users user);

    void save(Location location);

    void save(Picture picture);

//    List<Picture> listPictures();
//
//    Picture getFile(Long id);

    Users findByUsername(String username);

    Users findByEmail(String email);

    Location getClientLocation();

    String getClientIpAddr();
}
