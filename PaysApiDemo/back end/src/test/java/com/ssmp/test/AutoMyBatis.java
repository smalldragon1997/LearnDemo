package com.ssmp.test;

import com.ssmp.utils.Utils;

public class AutoMyBatis {
    public static void main(String args[]){
        String goodsname="测试支付宝";
        String istype ="1";
        String notify_url ="http://www.realfake.cn:8080/SSMP/savePay";
        String orderid ="2";
        String orderuid ="2";
        String price ="0.01";
        String return_url ="http://www.realfake.cn:8080/SSMP/";
        String token ="1accfbca7c2e54ef824319cec42710f0";
        String uid="a6fb395e410421b00431fdc7";

        System.out.println(Utils.EncoderByMd5(goodsname+istype+notify_url+orderid+orderuid+price+return_url+token+uid));
    }
}
