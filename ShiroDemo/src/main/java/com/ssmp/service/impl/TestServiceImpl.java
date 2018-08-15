package com.ssmp.service.impl;

import com.aliyun.oss.model.PutObjectResult;
import com.ssmp.dao.TestDao;
import com.ssmp.entity.PayInfo;
import com.ssmp.entity.Test;
import com.ssmp.service.TestService;
import com.ssmp.utils.ImgMessage;
import com.ssmp.utils.Message;
import com.ssmp.utils.oss.AliOssClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> getAllTest() {
        return testDao.selectTest();
    }

    @Override
    public ImgMessage saveImg(MultipartFile file) {

        // 创建新实例
        AliOssClient client = new AliOssClient();
        // 连接需要的信息
        client.setAccessKeyId("LTAIqWsAS5wyCmn5");
        client.setAccessKeySecret("9FNFrzwxvdzduw0k00QskeHuc3MnQr");
        client.setEndpoint("http://oss-cn-shenzhen.aliyuncs.com");

        // 返回的文件访问路径
        String url = "";

        try {

            //获取文件的原始名字
            String originalfileName = file.getOriginalFilename();
            // 按日期存储
            //String fileAddress = new Date().toString();
            //重新命名文件
            String suffix = originalfileName.substring(originalfileName.lastIndexOf(".") + 1);
            String fileName = new Date().getTime() + "-img." + suffix;

            // 获得文件流
            InputStream inputStream = file.getInputStream();

            // 上传到OSS
            client.putObject("shose-file", "shoseImg/" + fileName, inputStream);

            url += "http://shose-file.oss-cn-shenzhen.aliyuncs.com/shoseImg/" + fileName;
            System.out.println("下载url是:" + url);


        } catch (IOException e) {
            e.printStackTrace();
        }

        // 是否有可访问的地址
        if (url.length() < 2) {
            return new ImgMessage("fail", null);
        }
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("image_src", url);
        return new ImgMessage("success", data);
    }

    @Override
    public Message getPayList() {
        return new Message("200",testDao.selectPayInfo());
    }
    @Override
    public Message savePayInfo(PayInfo payInfo) {
        testDao.insertPayInfo(payInfo);
        return new Message("200",null);
    }
}
