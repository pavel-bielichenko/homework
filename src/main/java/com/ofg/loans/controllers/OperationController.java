package com.ofg.loans.controllers;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pavel on 19.04.16.
 */
@Controller
public class OperationController {

    private static final String PROCESS_PAGE = "redirect:/";

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = {"/requestLoan"}, method = RequestMethod.POST)
    public String requestLoan(@RequestParam(value = "loan_amount", required = false) Long loan_amount, HttpServletRequest request, ModelMap model) {
        LoanApplication loanApplication = operationService.createLoanApplication(loan_amount, request.getRemoteAddr());

        model.addAttribute("success", operationService.processLoan(loanApplication));

        return PROCESS_PAGE;
    }
}
