package com.ofg.loans.dao.clientLoanDetailsDao;

import com.ofg.loans.model.ClientLoanDetails;

import java.util.List;

/**
 * Created by pavel on 20.04.16.
 */
public interface ClientLoanDetailsDao {

    ClientLoanDetails findByUsername(String username);

    void persist(ClientLoanDetails clientLoanDetails);

    List<ClientLoanDetails> findOldEntity();

    void delete(ClientLoanDetails clientLoanDetails);
}
