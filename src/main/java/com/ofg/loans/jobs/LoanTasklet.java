package com.ofg.loans.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by pavel on 23.04.16.
 */
public class LoanTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(LoanTasklet.class);
    private JdbcTemplate jdbc;
    private List<String> queries;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        for(String query : queries){
            logger.info("inside LoanTasklet with query: " + query);
            execute(query);
        }
        return RepeatStatus.FINISHED;
    }

    private void execute(String query){
        try{
            jdbc.execute(query);
        }catch (Exception e){
            logger.error("LoanTasklet: Can't execute query. Reason: {}", e.getMessage());
        }
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
