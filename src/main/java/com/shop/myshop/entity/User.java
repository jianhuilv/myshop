package com.shop.myshop.entity;

public class User {


    int uid;
    String password;
    String mail;
    String username;
    boolean admin;
    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
