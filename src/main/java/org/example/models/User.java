package org.example.models;

public class User {

    private String name;
    private String email;
    private String mobile;

    private String memberShipStartDate;

    public User(String name, String email, String mobile, String memberShipStartDate) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.memberShipStartDate = memberShipStartDate;
    }

    public String getFullName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public  String getMembershipStartDate() {
        return memberShipStartDate;
    }
}
