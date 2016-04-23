package com.ofg.loans.model;

/**
 * Created by pavel on 20.04.16.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client_loan_details")
public class ClientLoanDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "loan_request_date", nullable = false)
    private Date loanApplicationDate;

    @Column(name = "request_count", nullable = false)
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoanApplicationDate() {
        return loanApplicationDate;
    }

    public void setLoanApplicationDate(Date loanApplicationDate) {
        this.loanApplicationDate = loanApplicationDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
