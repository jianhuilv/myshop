package com.shop.myshop.controller.utils;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class R {
    private Boolean flag;
    private Object data;

    public R(){};
    public R(boolean flag,Object data){
        this.data=data;
        this.flag=flag;
    }

    public R(boolean flag){
        this.flag=flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
