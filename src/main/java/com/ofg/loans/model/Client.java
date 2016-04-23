package com.ofg.loans.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Client entity.
 */

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "state", nullable = false)
    private String state = State.ACTIVE.getState();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_loan_application", joinColumns = {@JoinColumn(name = "client_id")}, inverseJoinColumns = {@JoinColumn(name = "loan_application_id")})
    private Set<LoanApplication> loanApplications = new HashSet<LoanApplication>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_user_profile",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_profile_id")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<LoanApplication> getLoanApplications() {
        return loanApplications;
    }

    public void setLoanApplications(Set<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!firstName.equals(client.firstName)) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (!username.equals(client.username)) return false;
        return password.equals(client.password);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

}
