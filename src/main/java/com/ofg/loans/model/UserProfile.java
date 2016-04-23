package com.ofg.loans.model;

import javax.persistence.*;

/**
 * Created by pavel on 19.04.16.
 */
@Entity
@Table(name="user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;

        UserProfile that = (UserProfile) o;

        if (id != that.id) return false;
        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }
}
