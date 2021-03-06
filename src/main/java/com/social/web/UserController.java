package com.social.web;

import com.social.enums.BodyType;
import com.social.enums.LifeCycle;
import com.social.enums.RolEnum;
import com.social.helpers.RespHelper;
import com.social.helpers.TokenHelper;
import com.social.model.Location;
import com.social.model.Roles;
import com.social.model.Users;
import com.social.service.UserService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

import static com.social.constants.SecurityConstants.HEADER_STRING;
import static com.social.constants.SecurityConstants.TOKEN_PREFIX;

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
            if(user.getPassword()==null || user.getPassword().length()<6) {
                if (user.getPassword().equals(user.getPasswordConfirm())) {
                    if (userService.findByUsername(user.getUsername()) == null) {
                        Roles userRole = userService.findByRoleName(RolEnum.USER);
                        user.setRoles(Collections.singleton(userRole));
                        user.setName(user.getName());
                        user.setLifecycle(LifeCycle.APPROVED);
                        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                        Location loc = userService.getClientLocation();
                        if (loc != null) {
                            user.setLocations(Collections.singleton(loc));
                        }
                        userService.save(user);
                        respHelper.sendOk(resp, "");
                    } else {
                        respHelper.sendErr(resp, "backErr.user_exists", "Registration error: User allready exists");
                    }
                } else {
                    respHelper.sendErr(resp, "backErr.reg_pass_no_match", "Registration error: Password not same with confirmation password");
                }
            } else {
                respHelper.sendErr(resp, "backErr.pass_ng_complex", "Registration error: Password not complex");
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
                Location loc = userService.getClientLocation();
                if(loc!=null) {
                    Users user = userService.findByUsername(loginUser.getUsername());
                    Set<Location> locSet = user.getLocations();
                    locSet.add(loc);
                    user.setLocations(locSet);
                    userService.save(user);
                }
                respHelper.sendOk(resp, token);
            }catch (AuthenticationException ae){
                respHelper.sendErr(resp, "backErr.login_no_account","Account does not exists");
            }
        }
    }

    @GetMapping(path="/users/getAll")
    public void getAllUsers(HttpServletResponse resp) {
        try {
//            int intFromReq = Integer.decode(fromReq);
//            int toFromReq = Integer.decode(toReq);
            //List<Users> usersList = userService.findAll(intFromReq,toFromReq);
            List<Users> usersList = userService.findAll();
            respHelper.sendOk(resp, usersList);
        }catch (NumberFormatException n){
            respHelper.sendErr(resp,"","Users table param is not a number");
        }
    }

    @PostMapping(path="users/updateUser")
    public void updateUser(@Valid @RequestBody Users recUser, BindingResult result, HttpServletResponse resp){
        if(result.hasErrors() && !(result.getErrorCount()==1 && result.getFieldError().getField().equals("agreedTerms"))){
            respHelper.sendErr(resp, "backErr.login_validation_err", "Registration error: " + result.getAllErrors().toString());
        }else {
            boolean res = userService.updateUserAsAdminAndSave(recUser);
            if (res){
                respHelper.sendOk(resp,"");
            }else {
                respHelper.sendErr(resp,"usr_adm_upd_err","Error when updating user as admin");
            }
        }
    }

    @PostMapping(path="users/newUser")
    public void newUser(@Valid @RequestBody Users user, BindingResult result, HttpServletResponse resp){
        if(result.hasErrors()){
            respHelper.sendErr(resp, "backErr.login_validation_err", "Registration error: " + result.getAllErrors().toString());
        }else {
                //List<Users> usersList = userService.findAll(intFromReq,toFromReq);
                userService.save(user);
                respHelper.sendOk(resp, "");
        }
    }

    @GetMapping(path="users/invertFav")
    public void updateUser(@RequestParam("id") String userID, HttpServletRequest req, HttpServletResponse resp){
            String header = req.getHeader(HEADER_STRING);
            if (header != null && header.startsWith(TOKEN_PREFIX)) {
                String authToken = header.replace(TOKEN_PREFIX, "");
                String username = tokenHelper.getUsernameFromToken(authToken);
                Users currentUser = userService.findByUsername(username);
                if(currentUser.getFavourite()==null){
                    currentUser.setFavourite(new HashSet<>());
                }
                if(currentUser.getFavourite().contains(userID)){
                    currentUser.getFavourite().remove(userID);
                }else{
                    currentUser.getFavourite().add(userID);
                }
                userService.save(currentUser);
            }
            respHelper.sendOk(resp, "");
    }

    @GetMapping(path="users/currentUser")
    public void getCurrentUser(HttpServletRequest req, HttpServletResponse resp){
        String header = req.getHeader(HEADER_STRING);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            String authToken = header.replace(TOKEN_PREFIX, "");
            String username = tokenHelper.getUsernameFromToken(authToken);
            Users currentUser = userService.findByUsername(username);
            respHelper.sendOk(resp, currentUser);
        }else{
            respHelper.sendOk(resp, "");
        }
    }

    @GetMapping(path="users/deleteUsers")
    public void deleteUsers(@RequestParam("unList") Set<String> userNamesList, HttpServletRequest req, HttpServletResponse resp){
    userService.deleteByUserNamesList(userNamesList);
    }

    @GetMapping(path="users/getSelectors")
    public void getSelectors(HttpServletResponse resp){
            respHelper.sendOk(resp, userService.getAllEnumTypes());
    }
}
