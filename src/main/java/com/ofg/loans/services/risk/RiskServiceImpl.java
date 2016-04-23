package com.ofg.loans.services.risk;

import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDao;
import com.ofg.loans.exceptions.RiskException;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.RiskEnum;
import com.ofg.loans.risk.RiskHandler;
import com.ofg.loans.risk.impl.IpCountRiskHandler;
import com.ofg.loans.risk.impl.TimeRangeRiskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavel on 19.04.16.
 */
@Component
public class RiskServiceImpl implements RiskService {

    @Autowired
    private ClientLoanDetailsDao clientLoanDetailsDao;


    public Boolean approve(LoanApplication loanApplication) {
        RiskHandler chain = setUpChain();
        return chain.handleRequest(loanApplication, RiskEnum.TIME_RANGE_RISK) && chain.handleRequest(loanApplication, RiskEnum.IP_RISK);
    }

    private RiskHandler setUpChain() {

        TimeRangeRiskHandler timeRangeHandler = new TimeRangeRiskHandler();
        IpCountRiskHandler ipHandler = new IpCountRiskHandler();
        ipHandler.setClientLoanDao(clientLoanDetailsDao);

        ipHandler.setNextSuccessor(timeRangeHandler);
        timeRangeHandler.setNextSuccessor(ipHandler);

        return ipHandler;
    }
}
