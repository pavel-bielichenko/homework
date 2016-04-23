package com.ofg.loans.model;

/**
 * Created by pavel on 19.04.16.
 */
public enum UserProfileType {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }
}
