package com.social.web;

import com.social.helpers.RespHelper;
import com.social.helpers.TokenHelper;
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

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid Users user, BindingResult result, HttpServletResponse resp) {

        if(user!=null && user.getName()!=null && user.getUsername()!=null && user.getPassword()!=null && user.getPasswordConfirm()!=null
            && user.getPassword().equals(user.getPasswordConfirm())) {
            user.setName(user.getName());
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);
            respHelper.sendOk(resp,"");
        }
        else{
            respHelper.sendErr(resp,"Cheat Register");
        }
    }

    @PostMapping(path="/authenticate")
    public void login(@RequestBody Users loginUser, HttpServletResponse resp) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenHelper.generateToken(authentication);
        respHelper.sendOk(resp, token);
    }
}
