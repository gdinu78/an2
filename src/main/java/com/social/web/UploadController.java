package com.social.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.enums.LifeCycle;
import com.social.enums.PictureKind;
import com.social.enums.PictureType;
import com.social.model.Picture;
import com.social.service.SecurityService;
import com.social.service.UserService;
import org.apache.catalina.core.ApplicationPart;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;


@MultipartConfig
@Controller
public class UploadController{
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserService userService;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @GetMapping("/upload")
//    public String fileUploadForm(Model model) {
//        return "fileUploadForm";
//    }
//
//    // Handling file upload request
//    @PostMapping("/upload")
//    public void fileUpload(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        if (ServletFileUpload.isMultipartContent(request)) {
//            String fileName = null;
//            PictureKind pKind = PictureKind.PUBLIC;
//            PictureType type;
//            String userName = securityService.findLoggedInUsername();
//            if (userName != null) {
//                Path uploadDir;
//                Path uploadedFile;
//                Path rootDir = FileSystems.getDefault().getRootDirectories().iterator().next();
//                Collection<Part> parts = request.getParts();
//                String result = ((ApplicationPart) parts.stream().filter(a -> a.getName().equals("img_type")).findFirst().orElseGet(() -> parts.iterator().next())).getString("UTF-8");
//                if (result != null && result.equals("avatar")) {
//                    pKind = PictureKind.AVATAR;
//                } else if (result != null && result.equals("private")) {
//                    pKind = PictureKind.PRIVATE;
//                }
//                Part filePart = parts.stream().filter(a -> a.getSubmittedFileName() != null).findFirst().orElseGet(() -> parts.iterator().next());
//                if (filePart != null && filePart.getSubmittedFileName() != null) {
//                    type = getType(filePart.getSubmittedFileName());
//                    if (type != null) {
//                        fileName = new BigInteger(130, new SecureRandom()).toString(32) +
//                                parseFileFormat(filePart.getSubmittedFileName());
//                    }
//                    uploadDir = Paths.get(rootDir.toString(), "upload", userName);
//                    Files.createDirectories(uploadDir);
//                    uploadedFile = Paths.get(uploadDir.toString(), fileName);
//                    try (InputStream input = filePart.getInputStream();
//                         OutputStream output = new FileOutputStream(uploadedFile.toFile())) {
//                        FileCopyUtils.copy(input, output);
//                    }
//                    Picture picture = new Picture();
//                    picture.setPicturePath(uploadedFile.toAbsolutePath().toString());
//                    picture.setType(type);
//                    picture.setUser(userService.findByUsername(userName));
//                    picture.setPictureKind(pKind);
//                    picture.setLifecycle(LifeCycle.CREATED);
//                    userService.save(picture);
//                }
//            }
//        }
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        JSONObject json=new JSONObject();
//        json.put("","");
//        out.print(json);
//        out.close();
//    }
//
//    @PostMapping(value = "/removeFile", params="file")
//    public void removeFile(@RequestParam("file") String fileName, HttpServletResponse response) {
//        Query query;
//        String userName = securityService.findLoggedInUsername();
//        Path rootDir = FileSystems.getDefault().getRootDirectories().iterator().next();
//        String path = Paths.get(rootDir.toString(), "upload", userName, fileName).toString();
//        query= em.createQuery("SELECT pics FROM Picture pics Join pics.user u WHERE u.username=:username and pics.picturePath=:path");
//        query.setParameter("username", userName);
//        query.setParameter("path", path);
//        Picture result = (Picture) query.getResultList().get(0);
//        result.setLifecycle(LifeCycle.DELETED);
//        userService.save(result);
//        response.setContentType("application/json");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject json=new JSONObject();
//        json.put("","");
//        out.print(json);
//        out.close();
//    }
//
//    @PostMapping(value = "/downloadFile", params="file")
//    public void downloadFile(@RequestParam("file") String fileName, HttpServletResponse response) {
//        String userName = securityService.findLoggedInUsername();
//        Path rootDir = FileSystems.getDefault().getRootDirectories().iterator().next();
//        Path file = Paths.get(rootDir.toString(), "upload", userName, fileName);
//        if(file.toFile().exists()) {
//            InputStream inputStream;
//            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//            try {
//                inputStream = Files.newInputStream(file);
//                IOUtils.copy(inputStream, response.getOutputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @RequestMapping(value = {"/myPicturesList/{criteria}"})
//    public void listPictures(@PathVariable("criteria") String criteria, HttpServletResponse response) {
//        PictureKind kind = null;
//        Query query;
//        if(criteria.equalsIgnoreCase("avatar")){
//            kind = PictureKind.AVATAR;
//        }else if(criteria.equalsIgnoreCase("public")){
//            kind = PictureKind.PUBLIC;
//        }else if(criteria.equalsIgnoreCase("private")){
//            kind = PictureKind.PRIVATE;
//        }
//        String userName = securityService.findLoggedInUsername();
//        if(kind==null){
//            query= em.createQuery("SELECT pics FROM Picture pics Join pics.user u WHERE u.username=:username AND pics.lifecycle<>:deleted");
//        }else {
//            query = em.createQuery("SELECT pics FROM Picture pics Join pics.user u WHERE u.username=:username and pics.pictureKind=:kind");
//            query.setParameter("kind",kind);
//        }
//        query.setParameter("username",userName);
//        query.setParameter("deleted",LifeCycle.DELETED);
//        List<Picture> result = query.getResultList();
//        JSONArray res = new JSONArray();
//        Map resMap = new HashMap();
//        Optional<Picture> avatar = result.stream().filter(a->(a.getPictureKind().equals(PictureKind.AVATAR))).findFirst();
//        if(avatar.isPresent()) {
//            resMap.put("pKind", avatar.get().getPictureKind());
//            resMap.put("pPath", avatar.get().getPicturePath().replace("C:\\upload", "").replaceAll("\\\\","/"));
//        }
//        JSONObject jsonObject = new JSONObject(resMap);
//        res.put(jsonObject);
//        resMap = new HashMap();
//        List<Picture> publicPics = result.stream().filter(a->(a.getPictureKind().equals(PictureKind.PUBLIC))).collect(Collectors.toList());
//        if(publicPics!=null && publicPics.size()>0) {
//            resMap.put("pKind", PictureKind.PUBLIC);
//            resMap.put("pPath",publicPics.stream().map(a->a.getPicturePath().replace("C:\\upload","")
//            .replaceAll("\\\\","/")).collect(Collectors.toList()));
//        }
//        res.put(resMap);
//        resMap = new HashMap();
//        List<Picture> privatePics = result.stream().filter(a->(a.getPictureKind().equals(PictureKind.PRIVATE))).collect(Collectors.toList());
//        if(privatePics!=null && privatePics.size()>0) {
//            resMap.put("pKind", PictureKind.PRIVATE);
//            resMap.put("pPath",publicPics.stream().map(a->a.getPicturePath().replace("C:\\upload","")
//            .replaceAll("\\\\","/")).collect(Collectors.toList()));
//        }
//        res.put(resMap);
//        try {
//            response.getWriter().print(res);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        response.setContentType("application/json");
//    }
//
//    @GetMapping(value = "/preview", params="path")
//    public void previewFiles(@RequestParam("path") String path, HttpServletResponse response) {
//        Path rootDir = FileSystems.getDefault().getRootDirectories().iterator().next();
//        String userName = securityService.findLoggedInUsername();
//        //check permissions for private pics
//        Path uploadDir = Paths.get(rootDir.toString(), "upload", path);
//        Path file=Paths.get(uploadDir.toUri());
//        if(file.toFile().exists()) {
//            InputStream inputStream;
//            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//            try {
//                inputStream = Files.newInputStream(file);
//                IOUtils.copy(inputStream, response.getOutputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @GetMapping(value = "/getAvatar")
//    public void previewFiles(HttpServletResponse response) {
//        Path rootDir = FileSystems.getDefault().getRootDirectories().iterator().next();
//        String userName = securityService.findLoggedInUsername();
//        Query query= em.createQuery("SELECT pics FROM Picture pics Join pics.user u WHERE u.username=:username AND pics.lifecycle<>:deleted AND pics.pictureKind=:kind");
//        query.setParameter("kind",PictureKind.AVATAR);
//        query.setParameter("username",userName);
//        query.setParameter("deleted",LifeCycle.DELETED);
//        List<Picture> result = query.getResultList();
//        String path;
//        if(result!=null && result.size()>0){
//            path=result.get(0).getPicturePath();
//        }else{
//             path = Paths.get(rootDir.toString(), "upload", "default_avatar_male.jpg").toString();
//        }
//        Path uploadDir = Paths.get(path);
//        Path file=Paths.get(uploadDir.toUri());
//        if(file.toFile().exists()) {
//            InputStream inputStream;
//            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//            try {
//                inputStream = Files.newInputStream(file);
//                IOUtils.copy(inputStream, response.getOutputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static String parseFileFormat(String fileName) {
//        fileName = fileName.toLowerCase();
//        int dotPosition = fileName.lastIndexOf(".");
//        String format = fileName.substring(dotPosition, fileName.length());
//        return format;
//    }
//
//    private PictureType getType(String fileName) {
//        String format = parseFileFormat(fileName);
//        PictureType[] values = PictureType.values();
//        for (int i = 0; i < values.length; i++) {
//            for (int j = 0; j < values[i].getFormats().length; j++) {
//                if (values[i] == PictureType.IMAGES && values[i].getFormats()[j].equals(format)) {
//                    return PictureType.IMAGES;
//                } else if (values[i] == PictureType.VIDEOS && values[i].getFormats()[j].equals(format)) {
//                    return PictureType.VIDEOS;
//                } else if (values[i] == PictureType.MUSICS && values[i].getFormats()[j].equals(format)) {
//                    return PictureType.MUSICS;
//                }
//            }
//        }
//        return null;
//    }
}