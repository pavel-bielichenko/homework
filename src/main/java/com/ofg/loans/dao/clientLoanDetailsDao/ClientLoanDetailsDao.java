package com.ofg.loans.dao.clientLoanDetailsDao;

import com.ofg.loans.model.ClientLoanDetails;

/**
 * Created by pavel on 20.04.16.
 */
public interface ClientLoanDetailsDao {

    ClientLoanDetails findByUsername(String username);

    void persist(ClientLoanDetails clientLoanDetails);
}
