package com.social.initdata;

import com.social.enums.Gender;
import com.social.enums.LifeCycle;
import com.social.enums.RolEnum;
import com.social.model.Roles;
import com.social.model.Users;
import com.social.repository.RoleRepository;
import com.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Database initializer that populates the database with some
 * initial bank accounts using a JPA repository.
 *
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... strings) throws Exception {

        this.userRepository.deleteAll();
        this.roleRepository.deleteAll();

        Roles roleAdmin = new Roles();
        roleAdmin.setRoleName(RolEnum.ADMIN);
        roleRepository.save(roleAdmin);
        Roles roleUser = new Roles();
        roleAdmin.setRoleName(RolEnum.USER);
        roleRepository.save(roleUser);
        Roles roleSupplier = new Roles();
        roleAdmin.setRoleName(RolEnum.SUPPLIER);
        roleRepository.save(roleSupplier);

        Users user = new Users();
        user.setRoles(Collections.singleton(roleAdmin));
        user.setAgreedTerms(true);
        user.setGender(Gender.MALE);
        user.setUsername("a1@a");
        user.setName("a1@a");
        user.setLifecycle(LifeCycle.APPROVED);
        user.setPassword(bCryptPasswordEncoder.encode("admin01"));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode("admin01"));
        userRepository.save(user);

        user = new Users();
        user.setRoles(Collections.singleton(roleUser));
        user.setAgreedTerms(true);
        user.setGender(Gender.MALE);
        user.setUsername("u1@u");
        user.setName("u1@u");
        user.setLifecycle(LifeCycle.APPROVED);
        user.setPassword(bCryptPasswordEncoder.encode("user01"));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode("user01"));
        userRepository.save(user);
        System.out.println(" -- Database has been initialized");
    }
}
