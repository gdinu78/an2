package com.social.repository;

import com.social.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

//    Location findByUser_loc(User user_loc);

}
