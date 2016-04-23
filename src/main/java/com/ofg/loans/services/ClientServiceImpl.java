package com.ofg.loans.services;

import com.ofg.loans.dao.clientDao.ClientDao;
import com.ofg.loans.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pavel on 19.04.16.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao dao;

    public ClientDao getDao() {
        return dao;
    }

    public void setDao(ClientDao dao) {
        this.dao = dao;
    }

    public Client findById(Long id){
        return dao.findById(id);
    }

    public Client findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
