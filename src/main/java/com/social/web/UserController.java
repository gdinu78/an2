package com.social.web;

import com.social.enums.LifeCycle;
import com.social.enums.RolEnum;
import com.social.helpers.RespHelper;
import com.social.helpers.TokenHelper;
import com.social.model.FrontEndUser;
import com.social.model.Roles;
import com.social.model.Users;
import com.social.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
            respHelper.sendErr(resp, "backErr.reg_validation_err", "Registration error: " + result.getAllErrors().toString());
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
                respHelper.sendErr(resp, "backErr.reg_pass_no_match", "Registration error: Password not same with confirmation password");
            }
        }
    }

    @PostMapping(path="/authenticate")
    public void login(@Valid @RequestBody Users loginUser, BindingResult result, HttpServletResponse resp){
        if(result.hasErrors()){
            respHelper.sendErr(resp, "backErr.login_validation_err", "Registration error: " + result.getAllErrors().toString());
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
                Users u = userService.findByUsername(loginUser.getUsername());
                respHelper.sendOk(resp, u);
            }catch (AuthenticationException ae){
                respHelper.sendErr(resp, "backErr.login_no_account","Account does not exists");
            }
        }
    }

    @GetMapping(path="/users")
    public void getAllUsers(HttpServletResponse resp) {
        try {
//            int intFromReq = Integer.decode(fromReq);
//            int toFromReq = Integer.decode(toReq);
            //List<Users> usersList = userService.findAll(intFromReq,toFromReq);
            List<Users> usersList = userService.findAll();
            List<FrontEndUser> frontEndUsers = usersList.stream()
                    .map(a->new FrontEndUser(a)).collect(Collectors.toList());
            respHelper.sendOk(resp, frontEndUsers);
        }catch (NumberFormatException n){
            respHelper.sendErr(resp,"","Users table param is not a number");
        }
    }

    @GetMapping(path="/getUser")
    public void getUserById(@RequestParam("id") String id, HttpServletResponse resp) {
        try {
//            int intFromReq = Integer.decode(fromReq);
//            int toFromReq = Integer.decode(toReq);
            //List<Users> usersList = userService.findAll(intFromReq,toFromReq);
            int intId = Integer.decode(id);
            List<Users> usersList = userService.findAll();
            List<FrontEndUser> frontEndUsers = usersList.stream()
                    .map(a->new FrontEndUser(a)).collect(Collectors.toList());
            respHelper.sendOk(resp, frontEndUsers.get(intId));
        }catch (NumberFormatException n){
            respHelper.sendErr(resp,"","Users table param is not a number");
        }
    }

    @PostMapping(path="/updateUser")
    public void updateUser(@Valid @RequestBody Users user, BindingResult result, HttpServletResponse resp){
        if(result.hasErrors()){
            respHelper.sendErr(resp, "backErr.login_validation_err", "Registration error: " + result.getAllErrors().toString());
        }else {
            try {
//            int intFromReq = Integer.decode(fromReq);
//            int toFromReq = Integer.decode(toReq);
                //List<Users> usersList = userService.findAll(intFromReq,toFromReq);
                List<Users> usersList = userService.findAll();
                List<FrontEndUser> frontEndUsers = usersList.stream()
                        .map(a->new FrontEndUser(a)).collect(Collectors.toList());
                respHelper.sendOk(resp, "");
            }catch (NumberFormatException n){
                respHelper.sendErr(resp,"","Users table param is not a number");
            }
        }
    }
}
