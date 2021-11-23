package com.shop.myshop.entity;

import org.springframework.web.multipart.MultipartFile;

public class Production {

    int pid;
    String pname;
    String detail;
    int price;
    String image;
    MultipartFile image_file;
    int sold;
    String url;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getImage_file() {
        return image_file;
    }

    public void setImage_file(MultipartFile image_file) {
        this.image_file = image_file;
    }

    @Override
    public String toString() {
        return "Production{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", sold='" + sold + '\'' +
                '}';
    }
}
