package com.ssmp.dao;

import com.ssmp.entity.PayInfo;
import com.ssmp.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDao {

    @Select(value = "select * from test")
    public List<Test> selectTest();


    @Select(value = "select * from payinfo")
    public List<PayInfo> selectPayInfo();


    @Insert(value = "insert into payinfo(orderid,orderuid,price)value(#{orderid},#{orderuid},#{price})")
    public void insertPayInfo(PayInfo payInfo);
}
