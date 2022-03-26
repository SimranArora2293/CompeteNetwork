package com.example.navbar;

public class userTests {
    String email, pass, name, username, mobile, organisation;

    public userTests(String email, String pass, String name, String username, String mobile, String organisation) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.username = username;
        this.mobile = mobile;
        this.organisation = organisation;
    }

    public userTests() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

}
