package com.social.helpers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RespHelper {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public void sendOk(HttpServletResponse resp, Object body){
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE) ;
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> resJson = new HashMap<>();
        resJson.put("rc", 0);
        resJson.put("message", "OK");
        resJson.put("results",body);
        try {
            String res = mapper.writeValueAsString(resJson);
            resp.getWriter().print(res);
            logInfo(resp, "Response OK");
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    public void sendErr(HttpServletResponse resp, String messageToSend, String messageToLog){
        JSONObject resJson = new JSONObject();
        resJson.put("rc", 0);
        resJson.put("message", "ERROR");
        resJson.put("results",messageToSend);
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE) ;
        try {
            resp.getWriter().print(resJson);
            logWarn(resp, messageToLog);
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    private void logInfo(HttpServletResponse response, String message) {
        log.info(message + " with headers: " + response.getHeaderNames().stream().map(a->(a + "-" + response.getHeader(a)))
                .collect(Collectors.joining(", ")) + " at time: " + LocalDateTime.now());
   }
    private void logWarn(HttpServletResponse response, String message) {
        log.warn(message + " with headers: " + response.getHeaderNames().stream().map(a->(a + "-" + response.getHeader(a)))
                .collect(Collectors.joining(", ")) + " at time: " + LocalDateTime.now());
    }
}
