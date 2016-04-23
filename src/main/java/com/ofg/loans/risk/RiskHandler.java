package com.ofg.loans.risk;

import com.ofg.loans.exceptions.RiskException;
import com.ofg.loans.model.LoanApplication;

/**
 * Created by pavel on 20.04.16.
 */
public abstract class RiskHandler {

    RiskHandler nextSuccessor;

    public void setNextSuccessor(RiskHandler nextSuccessor) {
        this.nextSuccessor = nextSuccessor;

    }

    public RiskHandler getNextSuccessor() {
        return nextSuccessor;
    }

    public abstract boolean handleRequest(LoanApplication loanApplication, RiskEnum risk);
}
