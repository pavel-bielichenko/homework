package com.ofg.loans.jobs.schedulers;

import java.util.Date;
import java.util.List;

import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDao;
import com.ofg.loans.dao.clientLoanDetailsDao.ClientLoanDetailsDaoImpl;
import com.ofg.loans.model.ClientLoanDetails;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pavel on 23.04.16.
 */
@Component
@EnableScheduling
public class RunScheduler {

    @Autowired
    private ClientLoanDetailsDao clientLoanDetailsDao;

    @Scheduled(fixedDelay = 60 * 1000)
    @Transactional
    public void run() {
        try {
            List<ClientLoanDetails> oldDetails = clientLoanDetailsDao.findOldEntity();
            oldDetails.forEach(clientLoanDetailsDao::delete);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
