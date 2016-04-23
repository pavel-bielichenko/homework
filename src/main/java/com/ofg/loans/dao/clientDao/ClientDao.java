package com.ofg.loans.dao.clientDao;

import com.ofg.loans.model.Client;

/**
 * Created by pavel on 19.04.16.
 */
public interface ClientDao {

    Client findById(Long id);

    Client findByUsername(String username);

    void persist(Client client);
}
