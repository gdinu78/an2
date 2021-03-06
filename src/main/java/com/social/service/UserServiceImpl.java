package com.social.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.enums.*;
import com.social.model.Location;
import com.social.model.Picture;
import com.social.model.Roles;
import com.social.model.Users;
import com.social.repository.LocationRepository;
import com.social.repository.PicturesRepository;
import com.social.repository.RoleRepository;
import com.social.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PicturesRepository pictureRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void save(Users user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<Roles>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(user!=null) {
            for (Roles role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }else{
            throw new UsernameNotFoundException(username);
        }
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

//    @Override
//    public List<Picture> listPictures() {
//        pictureRepository.list();
//    }
//
//    @Override
//    public Picture getFile(Long id) {
//        pictureRepository.get(id);
//    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Roles findByRoleName(RolEnum rolEnum) {
        return roleRepository.findByRoleName(rolEnum);
    }

//    @Override
//    public List<Users> findAll(int fromRecordNo, int toRecordNo) {
//        List<Users> usersList = userRepository
//                .findAll(new PageRequest(fromRecordNo, toRecordNo)).getContent();
//        return usersList;
//    }

    @Override
    public List<Users> findAll(){ return userRepository.findAll(); }

    @Override
    public Users findByUserID(UUID id){ return userRepository.findByUserID(id); }

    private Set<SimpleGrantedAuthority> getAuthority(Users user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().getType()));
            //authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public Location getClientLocation() {
        Location location=null;
        String ip = getClientIpAddr();
        if (ip != null) {
        try {
                URL url = new URL("http://ip-api.com/json/" + ip);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> jsonMap = mapper.readValue(br, Map.class);
                if (jsonMap.get("status").equals("success")) {
                    location = new Location();
                    location.setCountry((String) jsonMap.get("country"));
                    location.setRegionName((String) jsonMap.get("regionName"));
                    location.setCity((String) jsonMap.get("city"));
                    location.setZipCode((String) jsonMap.get("zip"));
                    location.setLat((Double) jsonMap.get("lat"));
                    location.setLon((Double) jsonMap.get("lon"));
                    location.setIsp((String) jsonMap.get("isp"));
                    location.setOrg((String) jsonMap.get("org"));
                    location.setAsTxt((String) jsonMap.get("as"));
                    location.setIpAddresss((String) jsonMap.get("query"));
                    location.setZonedDateTime(ZonedDateTime.now());
                } else {
                    //fail
                }
                conn.disconnect();

            } catch(MalformedURLException e){

                e.printStackTrace();

            } catch(IOException e){

                e.printStackTrace();

            }
        }
        return location;
    }

    @Override
    public String getClientIpAddr() {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Override
    public Map<String,List<String>> getAllEnumTypes(){
        Map<String,List<String>> result = new HashMap<>();
        result.put(BodyType.class.getSimpleName(),BodyType.getAllTypes());
        result.put(Drinking.class.getSimpleName(),Drinking.getAllTypes());
        result.put(Education.class.getSimpleName(),Education.getAllTypes());
        result.put(Ethnicity.class.getSimpleName(),Ethnicity.getAllTypes());
        result.put(Gender.class.getSimpleName(),Gender.getAllTypes());
        result.put(HairColor.class.getSimpleName(),HairColor.getAllTypes());
        result.put(Income.class.getSimpleName(),Income.getAllTypes());
        result.put(Language.class.getSimpleName(),Language.getAllTypes());
        result.put(LifeCycle.class.getSimpleName(),LifeCycle.getAllTypes());
        result.put(Lifestyle.class.getSimpleName(),Lifestyle.getAllTypes());
        result.put(Occupation.class.getSimpleName(),Occupation.getAllTypes());
        result.put(PictureKind.class.getSimpleName(),PictureKind.getAllTypes());
        result.put(PictureType.class.getSimpleName(),PictureType.getAllTypes());
        result.put(Relationship.class.getSimpleName(),Relationship.getAllTypes());
        result.put(RolEnum.class.getSimpleName(),RolEnum.getAllTypes());
        result.put(Smoking.class.getSimpleName(),Smoking.getAllTypes());
        result.put(Worth.class.getSimpleName(),Worth.getAllTypes());
        result.put(Permission.class.getSimpleName(),Permission.getAllTypes());
        return result;
    }

    @Override
    public boolean updateUserAsAdminAndSave(Users userFrom){
        try {
            Users userTo = findByUsername(userFrom.getUsername());
            userTo.setUsername(userFrom.getUsername());
            userTo.setName(userFrom.getName());
            //Set<Roles> roles = userFrom.getRoles().stream().map(a-> roleRepository.findByRoleName(a.getRoleName())).collect(Collectors.toSet());
            userTo.setRoles(userFrom.getRoles());
            userTo.setGender(userFrom.getGender());
            userTo.setLifecycle(userFrom.getLifecycle());
            userTo.setLocation(userFrom.getLocation());
            userTo.setLocations(userFrom.getLocations());
            userTo.setFavourite(userFrom.getFavourite());
            userTo.setAnnualIncome(userFrom.getAnnualIncome());
            userTo.setBirthDate(userFrom.getBirthDate());
            userTo.setBodyType(userFrom.getBodyType());
            userTo.setChildren(userFrom.getChildren());
            userTo.setDescrAboutME(userFrom.getDescrAboutME());
            userTo.setDescrLookingFor(userFrom.getDescrLookingFor());
            userTo.setDescrLookingForMore(userFrom.getDescrLookingForMore());
            userTo.setDrinking(userFrom.getDrinking());
            userTo.setEducation(userFrom.getEducation());
            userTo.setEthnicity(userFrom.getEthnicity());
            userTo.setHairColor(userFrom.getHairColor());
            userTo.setHeading(userFrom.getHeading());
            userTo.setHeight(userFrom.getHeight());
            userTo.setLanguage(userFrom.getLanguage());
            userTo.setLastActive(userFrom.getLastActive());
            userTo.setLifestyle(userFrom.getLifestyle());
            userTo.setNetWorth(userFrom.getNetWorth());
            userTo.setOccupation(userFrom.getOccupation());
            userTo.setPics(userFrom.getPics());
            userTo.setRelationship(userFrom.getRelationship());
            userTo.setSmoking(userFrom.getSmoking());
            save(userTo);
            return true;
        }catch (Exception e){
            log.error(e.getStackTrace().toString());
            return false;
        }
    }

    @Override
    public void deleteByUserNamesList(Set<String> uns){
        userRepository.deleteByUserNamesList(uns);
    }
}
