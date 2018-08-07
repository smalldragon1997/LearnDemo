package com.ssmp.entity;

public class PayInfo {
    private String orderid;
    private String orderuid;
    private String price;

    public PayInfo(String orderid, String orderuid, String price) {
        this.orderid = orderid;
        this.orderuid = orderuid;
        this.price = price;
    }

    public PayInfo() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderuid() {
        return orderuid;
    }

    public void setOrderuid(String orderuid) {
        this.orderuid = orderuid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
