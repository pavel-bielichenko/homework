package com.ofg.loans.risk.impl;

import com.ofg.loans.exceptions.RiskException;
import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.RiskEnum;
import com.ofg.loans.risk.RiskHandler;
import com.ofg.loans.utils.TimeFormatUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pavel on 20.04.16.
 */
@Component
public class TimeRangeRiskHandler extends RiskHandler {

    private static final Integer MAXIMUM_LOAN_AMOUNT = 100;

    @Override
    public boolean handleRequest(LoanApplication loanApplication, RiskEnum risk) {
        if (risk == risk.TIME_RANGE_RISK) {
            System.out.println("inside TimeRangeRiskHandler");
            if (!checkTimeRange(loanApplication)) {
                return false;
            }
        } else {
            if (getNextSuccessor() != null) {
                getNextSuccessor().handleRequest(loanApplication, risk);
            }
        }
        return true;
    }

    private boolean checkTimeRange(LoanApplication loanApplication) {
        Long requestLoanDate = loanApplication.getLoanDate().getTime();
        LocalDate date = LocalDate.now();
        if (requestLoanDate < TimeFormatUtil.formatToDate() && requestLoanDate > TimeFormatUtil.formatFromDate()) {
            if (loanApplication.getAmount() >= MAXIMUM_LOAN_AMOUNT) {
                return false;
            }
        }
        return true;
    }

}
