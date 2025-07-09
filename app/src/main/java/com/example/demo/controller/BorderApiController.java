package com.example.demo.controller;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BorderApiController {
    private static final String TOKEN_AUTHORIZED_FOR_GET = "token authorized for get {}";
    private static final Logger logger = LoggerFactory.getLogger(BorderApiController.class);

    private ResponseEntity<Object> getResponse(HttpServletRequest req, String tokenAuthorizedFor)
            throws MalformedURLException {
        logger.info(tokenAuthorizedFor, req.getServletPath());
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("oauth2.hasScope('borderapi')")
    @GetMapping(value = "/border/api", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Object> getBorderApi(HttpServletRequest req) throws MalformedURLException {
        HttpMethod httpMethod = HttpMethod.valueOf(req.getMethod());
        logger.info("token authorized for {} {}", httpMethod, req.getServletPath());
        return getResponse(req, TOKEN_AUTHORIZED_FOR_GET);
    }
}
