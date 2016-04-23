package com.ofg.loans.risk.impl;

import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDao;
import com.ofg.loans.exceptions.RiskException;
import com.ofg.loans.model.ClientLoanDetails;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.RiskEnum;
import com.ofg.loans.risk.RiskHandler;
import com.ofg.loans.services.ClientService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by pavel on 20.04.16.
 */
@Component
public class IpCountRiskHandler extends RiskHandler {

    private static final Integer MAXIMUM_ATTEMPTS_PER_IP_ADDRESS = 3;

    private ClientLoanDetailsDao clientLoanDao;

    public void setClientLoanDao(ClientLoanDetailsDao clientLoanDao) {
        this.clientLoanDao = clientLoanDao;
    }

    @Override
    public boolean handleRequest(LoanApplication loanApplication, RiskEnum risk) {
        if (risk == risk.IP_RISK) {
            System.out.println("inside IpCountRiskHandler");
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            ClientLoanDetails details = clientLoanDao.findByUsername(user.getUsername());
            if (details.getCount() >= MAXIMUM_ATTEMPTS_PER_IP_ADDRESS) {
                return false;
            }
        } else {
            if (getNextSuccessor() != null) {
                getNextSuccessor().handleRequest(loanApplication, risk);
            }
        }
        return true;
    }
}
