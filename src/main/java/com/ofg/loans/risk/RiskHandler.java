package com.ofg.loans.risk;

import com.ofg.loans.model.LoanApplication;

/**
 * Created by pavel on 20.04.16.
 */
public abstract class RiskHandler {

    protected RiskHandler nextSuccessor;

    public void setNextSuccessor(RiskHandler nextSuccessor) {
        this.nextSuccessor = nextSuccessor;

    }

    public RiskHandler getNextSuccessor() {
        return nextSuccessor;
    }

    public boolean checkLoanApplication(LoanApplication loanApplication){
        if(!check(loanApplication)){
            return false;
        }
        if(nextSuccessor != null){
           return nextSuccessor.checkLoanApplication(loanApplication);
        }
        return true;
    }

    public abstract boolean check(LoanApplication loanApplication);
}
