package com.social.repository;

import com.social.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    //Page<Users> findAll(PageRequest pageRequest);
    List<Users> findAll();
}
