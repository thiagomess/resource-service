package com.example.demo.controller;

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
public class FakeDataServiceController {
    private static final Logger logger = LoggerFactory.getLogger(FakeDataServiceController.class);

    @PreAuthorize("oauth2.hasScope('fakedata')")
    @GetMapping(value = {
            "fakeapi/v1/users",
            "fakeapi/v1/products",
            "fakeapi/v1/orders/{order_id}",
            "fakeapi/v1/reports/summary",
            "fakeapi/v1/notifications",
            "fakeapi/v1/payments/simulation",
            "fakeapi/v1/reports/detail/{report_id}/{page}",
            "fakeapi/v1/reports/detail/{report_id}"
    }, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> fakeDataServiceController(
            HttpMethod httpMethod,
            HttpServletRequest req) {
        logger.info("Token autorizado for all fakeapi method, req: {}", req.getServletPath());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
