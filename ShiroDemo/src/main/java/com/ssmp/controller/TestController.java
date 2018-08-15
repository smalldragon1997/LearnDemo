package com.ssmp.controller;

import com.ssmp.entity.PayInfo;
import com.ssmp.service.TestService;
import com.ssmp.utils.ImgMessage;
import com.ssmp.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("getTest")
    @ResponseBody
    public Message getTest(){
        return new Message("200",testService.getAllTest());
    }

    @RequestMapping("uploadImg")
    @ResponseBody
    public ImgMessage uploadImg(@RequestParam(value = "file", required = false) MultipartFile imgFile){
        return testService.saveImg(imgFile);
    }
    @RequestMapping("fetchPayList")
    @ResponseBody
    public Message fetchPayList(){
        return testService.getPayList();
    }
    @RequestMapping("savePay")
    @ResponseBody
    public Message savePay(
            @RequestParam(value = "paysapi_id", required = true)String paysapi_id,
            @RequestParam(value = "orderid", required = true)String orderid,
            @RequestParam(value = "price", required = true)String price,
            @RequestParam(value = "realprice", required = true)String realprice,
            @RequestParam(value = "orderuid", required = true)String orderuid,
            @RequestParam(value = "key", required = true)String key){
        PayInfo payInfo = new PayInfo(orderid,orderuid,price);
        return testService.savePayInfo(payInfo);
    }

}
