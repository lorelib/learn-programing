package com.lorelib.mycat.service;

import com.alibaba.fastjson.JSON;
import com.lorelib.mycat.entity.TravelRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author listening
 * @description TravelRecordServiceTest:
 * @create 2017 07 26 下午2:17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelRecordServiceTest {
    @Autowired
    private ITravelRecordService travelRecordService;

    @Test
    public void getAllTest() {
        List<TravelRecord> list = travelRecordService.getAll();
        System.out.println(JSON.toJSONString(list));
    }
}
