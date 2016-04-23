package com.ofg.loans.risk.impl;

import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDao;
import com.ofg.loans.model.ClientLoanDetails;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.RiskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by pavel on 20.04.16.
 */
@Component
public class IpCountRiskHandler extends RiskHandler {

    private static final Integer MAXIMUM_ATTEMPTS_PER_IP_ADDRESS = 3;

    @Autowired
    private ClientLoanDetailsDao clientLoanDao;

    @Override
    public boolean check(LoanApplication loanApplication) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientLoanDetails details = clientLoanDao.findByUsername(user.getUsername());
        if (details != null && details.getCount() >= MAXIMUM_ATTEMPTS_PER_IP_ADDRESS) {
            return false;
        }
        return true;
    }
}
