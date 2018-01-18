package com.livro.capitulo4.springsecurity.model;

public enum UserProfileType {
	USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");
     
    private String userProfileType;
    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
