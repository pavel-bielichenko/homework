package com.ofg.loans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by pavel on 19.04.16.
 */
//@Entity
//@Table(name = "client_loan_application")
public class ClientLoanApplication {

//    @Column(name = "client_id")
    private Long clientId;

//    @Column(name = "loan_application_id")
    private Integer loanApplicationId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(Integer loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }
}
