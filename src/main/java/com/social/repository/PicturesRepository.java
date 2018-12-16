package com.social.repository;

import com.social.model.Location;
import com.social.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesRepository extends JpaRepository<Picture, Long> {

//    Location findByUser_loc(User user_loc);

}
