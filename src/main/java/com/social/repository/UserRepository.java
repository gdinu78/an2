package com.social.repository;

import com.social.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
    Users findByUserID(UUID id);
    Users findByName(String name);
    //Page<Users> findAll(PageRequest pageRequest);
    List<Users> findAll();

    /**
     * Delete all user with ids specified in {@code ids} parameter
     *
     * @param ids List of user ids
     */
    void deleteByUserNamesList(@Param("unList") Set<String> unList);
}
