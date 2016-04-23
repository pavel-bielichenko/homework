package com.ofg.loans.services.risk;

import com.ofg.loans.model.LoanApplication;
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
    private TimeRangeRiskHandler timeRangeHandler;

    @Autowired
    private IpCountRiskHandler ipHandler;

    public Boolean approve(LoanApplication loanApplication) {
        RiskHandler chain = setUpChain();
        return chain.checkLoanApplication(loanApplication);
    }

    private RiskHandler setUpChain() {
        timeRangeHandler.setNextSuccessor(ipHandler);
        return timeRangeHandler;
    }
}
