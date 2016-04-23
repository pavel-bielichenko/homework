package com.ofg.loans.dao.loanDao;

import com.ofg.loans.model.LoanApplication;

import java.util.List;

/**
 * Created by pavel on 19.04.16.
 */
public interface LoanApplicationDao {

    LoanApplication findById(Long id);

    List<LoanApplication> findAllByUsername(String username);

    void persist(LoanApplication loanApplication);
}
