package com.ofg.loans.services.risk;

import com.ofg.loans.model.LoanApplication;

public interface RiskService {

    Integer MAXIMUM_LOAN_AMOUNT = 100;

    Integer MAXIMUM_ATTEMPTS_PER_IP_ADDRESS = 3;

    Boolean approve(LoanApplication loanApplication);
}
