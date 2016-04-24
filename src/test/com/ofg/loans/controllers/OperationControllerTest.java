package com.ofg.loans.controllers;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.services.OperationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pavel on 23.04.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationControllerTest {

    private static final Long AMOUNT = 99L;

    private static final String IP = "127.0.0.1";

    private static final String PROCESS_PAGE = "redirect:/";

    @Mock
    private OperationService operationServiceMock;

    @Mock
    private HttpServletRequest requestMock;

    @Mock
    private ModelMap modelMock;

    @Mock
    private LoanApplication loanApplicationMock;

    @InjectMocks
    private OperationController operationController;

    @Before
    public void before() {
        when(requestMock.getRemoteAddr()).thenReturn(IP);
        when(operationServiceMock.createLoanApplication(AMOUNT, IP)).thenReturn(loanApplicationMock);
    }

    @Test
    public void requestLoanSuccessful() throws Exception {
        when(operationServiceMock.processLoan(loanApplicationMock)).thenReturn(true);

        String page = operationController.requestLoan(AMOUNT, requestMock, modelMock);

        verify(modelMock).addAttribute("success", true);
        assertEquals(page, PROCESS_PAGE);
    }

    @Test
    public void requestLoanFailed() throws Exception {
        when(operationServiceMock.processLoan(loanApplicationMock)).thenReturn(false);

        String page = operationController.requestLoan(AMOUNT, requestMock, modelMock);

        verify(modelMock).addAttribute("success", false);
        assertEquals(page, PROCESS_PAGE);
    }
}