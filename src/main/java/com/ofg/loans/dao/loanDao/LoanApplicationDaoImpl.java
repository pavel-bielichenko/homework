package com.ofg.loans.dao.loanDao;

import com.ofg.loans.dao.AbstractDao;
import com.ofg.loans.model.LoanApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 19.04.16.
 */
@Repository("loanApplicationDao")
public class LoanApplicationDaoImpl extends AbstractDao<Long, LoanApplication> implements LoanApplicationDao {

    public LoanApplication findById(Long id) {
        return null;
    }

    public List<LoanApplication> findAllByUsername(String username) {
        return new ArrayList<LoanApplication>();
    }

    public void persist(LoanApplication loanApplication) {
        super.persist(loanApplication);
    }

}
