package com.lorelib.mybatisplus.quickstart;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author listening
 * @description
 * @date 2017-10-09 13:41
 * @since 1.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class TestApp {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testBasic() {
        int result = 0;
        User user = new User();

        user.setName("listening2");
        result = userMapper.insert(user);

        user.setAge(18);
        result = userMapper.updateById(user);

        User user1 = userMapper.selectById(user.getId());

        List<User> userList = userMapper.selectList(
                new EntityWrapper<User>().eq("name", "listening2")
        );

        //result = userMapper.deleteById(user.getId());

        Assert.assertEquals(1, result);
    }

    @Test
    public void testPage() {
        List<User> userList = userMapper.selectPage(
                new Page<User>(1, 10),
                new EntityWrapper<User>()
                        .eq("name", "Tom")
                        .between("age", 1, 20)
        );
        System.out.println("size = " + userList.size());
    }

    @Test
    public void testUpdateTest() {
        User user = userMapper.selectById(1);
        user.setName("TomUpdate");
        int result = userMapper.updateTest(user);
        Assert.assertEquals(1, result);
    }
}
