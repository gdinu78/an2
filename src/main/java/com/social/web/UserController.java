package com.social.web;

import com.social.enums.LifeCycle;
import com.social.enums.RolEnum;
import com.social.helpers.RespHelper;
import com.social.helpers.TokenHelper;
import com.social.model.Roles;
import com.social.model.Users;
import com.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private TokenHelper tokenHelper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Resource(name = "userService")
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RespHelper respHelper;

    @PostMapping(path="/signup")
    public void signUp(@Valid @RequestBody  Users user, BindingResult result, HttpServletResponse resp) {
        if(result.hasErrors()){
            respHelper.sendErr(resp,"Registration error: " + result.getAllErrors().toString());
        }else {
            if (user.getPassword().equals(user.getPasswordConfirm())) {
                Roles userRole = userService.findByRoleName(RolEnum.USER);
                user.setRoles(Collections.singleton(userRole));
                user.setName(user.getName());
                user.setLifecycle(LifeCycle.CREATED);
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userService.save(user);
                respHelper.sendOk(resp, "");
            } else {
                respHelper.sendErr(resp, "Registration error: Password not same with confirmation password");
            }
        }
    }

    @PostMapping(path="/authenticate")
    public void login(@Valid @RequestBody Users loginUser, BindingResult result, HttpServletResponse resp){
        if(result.hasErrors()){
            respHelper.sendErr(resp,"Registration error: " + result.getAllErrors().toString());
        }else {
            try {
                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginUser.getUsername(),
                                loginUser.getPassword()
                        )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                final String token = tokenHelper.generateToken(authentication);
                respHelper.sendOk(resp, token);
            }catch (AuthenticationException ae){
                respHelper.sendErr(resp, "Authentication failed");
            }
        }
    }
}
