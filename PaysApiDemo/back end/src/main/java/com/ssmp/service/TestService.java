package com.ssmp.service;

import com.ssmp.entity.PayInfo;
import com.ssmp.entity.Test;
import com.ssmp.utils.ImgMessage;
import com.ssmp.utils.Message;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TestService {

    public List<Test> getAllTest();

    public ImgMessage saveImg(MultipartFile file);

    public Message getPayList();
    public Message savePayInfo(PayInfo payInfo);
}
