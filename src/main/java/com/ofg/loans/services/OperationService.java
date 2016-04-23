package com.ofg.loans.services;

import com.ofg.loans.dao.clientDao.ClientDao;
import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDao;
import com.ofg.loans.dao.loanDao.LoanApplicationDao;
import com.ofg.loans.model.Client;
import com.ofg.loans.model.ClientLoanDetails;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.services.risk.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by pavel on 19.04.16.
 */
@Service
public class OperationService {

    @Autowired
    private RiskService riskService;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientLoanDetailsDao clientLoanDao;

    @Transactional
    public boolean processLoan(LoanApplication loanApplication) {
        if (riskService.approve(loanApplication)) {
            String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            ClientLoanDetails clientLoanDetails = getClientLoanDetails(username, loanApplication);
            if (clientLoanDetails != null) {
                updateExistingClientLoanDetailsEntity(clientLoanDetails);
            } else {
                createNewClientLoanDetailsEntity(username, loanApplication);
            }
            return true;
        }
        return false;
    }

    public LoanApplication createLoanApplication(Long amount, String ip) {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setAmount(amount);
        loanApplication.setLoanDate(new Date());
        loanApplication.setIp(ip);
        return loanApplication;
    }

    private ClientLoanDetails getClientLoanDetails(String username, LoanApplication loanApplication) {
        Client client = clientDao.findByUsername(username);
        client.getLoanApplications().add(loanApplication);
        clientDao.persist(client);
        return clientLoanDao.findByUsername(username);
    }

    private void createNewClientLoanDetailsEntity(String username, LoanApplication loanApplication) {
        ClientLoanDetails newDetails = new ClientLoanDetails();
        newDetails.setUsername(username);
        newDetails.setIp(loanApplication.getIp());
        newDetails.setCount(1);
        newDetails.setLoanRequest(new Date());
        clientLoanDao.persist(newDetails);
    }

    private void updateExistingClientLoanDetailsEntity(ClientLoanDetails clientLoanDetails) {
        Integer currentCount = clientLoanDetails.getCount();
        clientLoanDetails.setCount(currentCount + 1);
        clientLoanDao.persist(clientLoanDetails);
    }

}
