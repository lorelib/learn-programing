package com.lorelib.mycat.service;

import com.alibaba.fastjson.JSON;
import com.lorelib.mycat.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author listening
 * @description UserServiceTest:
 * @create 2017 07 26 下午2:32.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void getAllTest() {
        List<User> list = userService.getAll();
        System.out.println(JSON.toJSONString(list));
    }
}
