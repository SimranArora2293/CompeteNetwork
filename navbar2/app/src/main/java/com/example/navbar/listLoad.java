package com.example.navbar;

import android.widget.Button;

public class listLoad {
    String name,comp,dead,fees,date,tym;
    int img;

    public listLoad(String name, String comp, String dead, String fees, String date, String tym, int img) {
        this.name = name;
        this.comp = comp;
        this.dead = dead;

        this.fees = fees;

        this.date = date;
        this.tym = tym;
        this.img=img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public listLoad() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTym() {
        return tym;
    }

    public void setTym(String tym) {
        this.tym = tym;
    }
}