package com.ofg.loans.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by pavel on 24.04.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ManagerControllerTest {

    private static final String USERNAME = "testUsername";
    private static final String LOGIN_PAGE = "login";
    private static final String LOGOUT_PAGE = "redirect:/login?logout";
    private static final String PROCESS_PAGE = "process";
    private static final String ACCESS_DENIED_PAGE = "accessDenied";

    @InjectMocks
    private ManagerController managerControllerMock;

    @Mock
    private ModelMap modelMock;

    @Mock
    private Authentication authentication;

    @Mock
    private HttpServletRequest requestMock;

    @Mock
    private HttpServletResponse responseMock;

    @Test
    public void testHomePage() throws Exception {
        String page = managerControllerMock.homePage(modelMock);

        verify(modelMock).addAttribute("greeting", "Hi, Welcome to loan application, please type loan amount");
        assertEquals(page, PROCESS_PAGE);
    }

    @Test
    public void testLoginPage() throws Exception {
        assertEquals(managerControllerMock.loginPage(), LOGIN_PAGE);
    }

    @Test
    public void testLogoutPage() throws Exception {
        assertEquals(managerControllerMock.logoutPage(requestMock, responseMock), LOGOUT_PAGE);
    }
}