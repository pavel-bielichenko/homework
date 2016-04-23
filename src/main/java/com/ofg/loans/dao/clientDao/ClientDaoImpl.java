package com.ofg.loans.dao.clientDao;

import com.ofg.loans.dao.AbstractDao;
import com.ofg.loans.dao.clientDao.ClientDao;
import com.ofg.loans.model.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by pavel on 19.04.16.
 */
@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Long, Client> implements ClientDao {

    public Client findById(Long id) {
        return getByKey(id);
    }

    public Client findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (Client) crit.uniqueResult();
    }

    public void persist(Client client){
        super.persist(client);
    }

}
