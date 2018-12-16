package com.social.web;

import com.social.helpers.RespHelper;
import com.social.model.Menus;
import com.social.repository.MenuRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

@RestController
@Controller
public class FrontController {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    RespHelper respHelper;

    @RequestMapping(value="/getNavItems")
    public void getNavItems(HttpServletResponse resp) {
        List<Menus> menus = menuRepository.fetchByType("header");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        Map resMap;
        for (Menus oneMenu: menus) {
            resMap = new HashMap();
            resMap.put("name", oneMenu.getMenu_name());
            resMap.put("prio", oneMenu.getPosition());
            jsonObject = new JSONObject(resMap);
            jsonArray.put(jsonObject);
        }
        respHelper.sendOk(resp, jsonArray);
    }
}
