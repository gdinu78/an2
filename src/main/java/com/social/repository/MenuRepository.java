package com.social.repository;


import com.social.model.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menus, Long> {

    List<Menus> fetchByType(@Param("menupar") String menuType);
}
