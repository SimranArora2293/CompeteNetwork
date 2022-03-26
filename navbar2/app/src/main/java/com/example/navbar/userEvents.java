package com.example.navbar;

public class userEvents {
    String eventtype,eventname,companyname,time,date,fees,lastdate;

    public userEvents(String eventtype, String eventname, String companyname, String time, String date, String fees, String lastdate) {
        this.eventtype = eventtype;
        this.eventname = eventname;
        this.companyname = companyname;
        this.time = time;
        this.date = date;
        this.fees = fees;
        this.lastdate = lastdate;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}
