package com.ssmp.utils.bufpay;

public class PayRet {
    private String status; // 请求结果
    private String aoid; //bufpay平台订单唯一标示可用于查询订单状态
    private String pay_type; //支付类型 alipay/wechat
    private String price; // 订单价格
    private String qr_price; //支付二维码的金额，如果为空表示使用的是不固定金额二维码，具体金额需要用户输入
    private String qr; //支付二维码内容
    private String qr_img; //支付二维码图片 base64 格式
    private String expires_in; //支付二维码剩余有效秒数
    private String return_url; //支付成功跳转地址

    public PayRet(String status, String aoid, String pay_type, String price, String qr_price, String qr, String qr_img, String expires_in, String return_url) {
        this.status = status;
        this.aoid = aoid;
        this.pay_type = pay_type;
        this.price = price;
        this.qr_price = qr_price;
        this.qr = qr;
        this.qr_img = qr_img;
        this.expires_in = expires_in;
        this.return_url = return_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAoid() {
        return aoid;
    }

    public void setAoid(String aoid) {
        this.aoid = aoid;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQr_price() {
        return qr_price;
    }

    public void setQr_price(String qr_price) {
        this.qr_price = qr_price;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getQr_img() {
        return qr_img;
    }

    public void setQr_img(String qr_img) {
        this.qr_img = qr_img;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }
}
