package com.ofg.loans.dao.clientLoanDetailsDao;

import com.ofg.loans.dao.AbstractDao;
import com.ofg.loans.model.ClientLoanDetails;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by pavel on 20.04.16.
 */
@Repository("ClientLoanDetailsDao")
public class ClientLoanDetailsDaoImpl extends AbstractDao<String, ClientLoanDetails> implements ClientLoanDetailsDao {

    public ClientLoanDetails findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        return (ClientLoanDetails) crit.uniqueResult();
    }

    public void persist(ClientLoanDetails clientLoanDetails){
        super.persist(clientLoanDetails);
    }

}
