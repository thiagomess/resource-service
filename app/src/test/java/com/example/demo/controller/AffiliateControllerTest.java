package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AffiliateControllerTest {

    @InjectMocks
    private AffiliateController controller;

	@BeforeEach
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAuthorizeGetAffiliateInfo() throws MalformedURLException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);

        when(httpServletRequest.getServletPath()).thenReturn("/affiliate/info");
        when(httpServletRequest.getMethod()).thenReturn("GET");

        ResponseEntity<Object> resp = controller.getAffiliate(httpServletRequest);
        assertEquals("Unexpected status code", HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    public void shouldAuthorizeGetAffiliateStatus() throws MalformedURLException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);

        when(httpServletRequest.getServletPath()).thenReturn("/affiliate/status");
        when(httpServletRequest.getMethod()).thenReturn("GET");

        ResponseEntity<Object> resp = controller.getAffiliate(httpServletRequest);
        assertEquals("Unexpected status code", HttpStatus.OK, resp.getStatusCode());
    }

}
