package com.ofg.loans.risk.impl;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.RiskHandler;
import com.ofg.loans.utils.TimeFormatUtil;
import org.springframework.stereotype.Component;

/**
 * Created by pavel on 20.04.16.
 */
@Component
public class TimeRangeRiskHandler extends RiskHandler {

    private static final Integer MAXIMUM_LOAN_AMOUNT = 100;

    @Override
    public boolean check(LoanApplication loanApplication) {
        if (!checkTimeRange(loanApplication)) {
            return false;
        }
        return true;
    }

    private boolean checkTimeRange(LoanApplication loanApplication) {
        Long requestLoanDate = loanApplication.getLoanDate().getTime();
        if (requestLoanDate < TimeFormatUtil.formatToDate() && requestLoanDate > TimeFormatUtil.formatFromDate()) {
            if (loanApplication.getAmount() >= MAXIMUM_LOAN_AMOUNT) {
                return false;
            }
        }
        return true;
    }
}
