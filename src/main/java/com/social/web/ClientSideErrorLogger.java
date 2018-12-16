package com.social.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/clientLog")
public class ClientSideErrorLogger {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${clientErrorLogSizeLimit}")
    private String clientErrorLogSizeLimit;

    /**
     * POST Post client-side error log to server.
     */
    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Boolean> logClientSideError(HttpServletRequest request) {

        long contentLength = request.getContentLengthLong();

        Map<String, String> headersInfo = getHeadersInfo(request);

        if (contentLength > Long.parseLong(clientErrorLogSizeLimit)) {
            log.warn("This request is too big and its content will not be logged. Headers: " + headersInfo);
        } else {
            try {
                log.warn("Client-side error occurred. Request headers: " + headersInfo  + "\n" + "Request body: " +
                        request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
            } catch (IOException e) {
                log.debug("Client-side error occurred but system cannot process error info.");
            }
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

}
