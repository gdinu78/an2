package com.social.helpers;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RespHelper {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public void sendOk(HttpServletResponse resp, Object body){
        JSONObject resJson = new JSONObject();
        resJson.put("rc", 0);
        resJson.put("message", "OK");
        resJson.put("results",body);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE) ;
        try {
            resp.getWriter().print(resJson);
            String headersInfo = getHeadersInfo(resp);
            log.info("Sent OK response with headers: " + headersInfo + " at time: " + LocalDateTime.now());
        } catch (IOException e) {
            log.error(e.getStackTrace().toString());
        }
    }

    private String getHeadersInfo(HttpServletResponse response) {

        //Map<String, String> map = response.getHeaderNames().stream().collect(Collectors.toMap(a->a,(a->response.getHeader(a))));
        return response.getHeaderNames().stream().map(a->(a + "-" + response.getHeader(a))).collect(Collectors.joining(", "));
//        map = response.get
//        while (headerNames.iterator().hasNext()) {
//            String key = headerNames.iterator().next();
//            String value = response.getHeader(key);
//            map.put(key, value);
//        }
//        return map.entrySet().stream()
//                .map(entry -> entry.getKey() + " - " + entry.getValue())
//                .collect(Collectors.joining(", "));
   }
}
