package com.ofg.loans.services;

import com.ofg.loans.model.Client;

/**
 * Created by pavel on 19.04.16.
 */
public interface ClientService {

    Client findById(Long id);

    Client findByUsername(String username);

}

