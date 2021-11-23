package com.shop.myshop.entity;

import java.sql.Timestamp;

public class Order {
    int oid;
    String pname;
    String username;
    int num;
    Timestamp currentTime;
    String mail;
    int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", pname='" + pname + '\'' +
                ", username='" + username + '\'' +
                ", num=" + num +
                ", currentTime=" + currentTime +
                ", mail='" + mail + '\'' +
                '}';
    }
}
