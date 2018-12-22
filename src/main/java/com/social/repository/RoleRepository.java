package com.social.repository;

import com.social.enums.RolEnum;
import com.social.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long>{
    Roles findByRoleName(RolEnum rolEnum);
}
