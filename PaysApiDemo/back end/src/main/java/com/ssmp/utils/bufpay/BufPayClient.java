package com.ssmp.utils.bufpay;


import com.alibaba.fastjson.JSON;

import com.ssmp.utils.Message;
import com.ssmp.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DELL on 2018/7/4.
 */

public class BufPayClient {

    private String appSecret = "81c3a33d5dd343e89e66f2c154eac4d8";
    private String apiNum = "61910";
    private String apiType = "pay";
    private String notify_url;
    private String return_url;

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getApiNum() {
        return apiNum;
    }

    public void setApiNum(String apiNum) {
        this.apiNum = apiNum;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public PayRet pay(String name, String pay_type, String price, String order_id, String order_uid) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        // api需要的参数
        formparams.add(new BasicNameValuePair("name", name));
        formparams.add(new BasicNameValuePair("pay_type", pay_type));
        formparams.add(new BasicNameValuePair("price", price));
        formparams.add(new BasicNameValuePair("order_id", order_id));
        formparams.add(new BasicNameValuePair("order_uid", order_uid));
        formparams.add(new BasicNameValuePair("sign", Utils.EncoderByMd5(name + pay_type + price + order_id + order_uid + notify_url + return_url + appSecret)));

        Message message = doPost(formparams);
        if (message.getCode().equals("200")) {
            System.out.println(message.getData().toString());
            return JSON.parseObject(message.getData().toString(), PayRet.class);
        }
        return null;
    }

    public Message doPost(List<NameValuePair> formparams) {

        try {
            StringBuffer res = new StringBuffer();
            HttpEntity reqEntity = null;
            reqEntity = new UrlEncodedFormEntity(formparams, "utf-8");

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://bufpay.com/api/" + apiType + "/" + apiNum+"?format=json");
            post.setEntity(reqEntity);
            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity resEntity = response.getEntity();
                BufferedReader br = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                String line;
                while ((line = br.readLine()) != null) {
                    res.append(line);
                }

                return JSON.parseObject(res.toString(), Message.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message("500", null);
    }
}
