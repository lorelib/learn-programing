package com.lorelib.mybatisplus.activerecord;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class TestApp2 {
    @Test
    public void testBasic() {
        boolean result = false;
        UserAR user = new UserAR();

        user.setName("listen");
        result = user.insert();

        user.setAge(25);
        result = user.updateById();

        UserAR user1 = user.selectById();

        List<UserAR> userList = user.selectList(
                new EntityWrapper<UserAR>().eq("name", "listen")
        );

        //result = user1.deleteById();

        Assert.assertEquals(true, result);
    }

    @Test
    public void testPage() {
        UserAR user = new UserAR();
        List<UserAR> userList = user.selectPage(
                new Page<UserAR>(1, 10),
                new EntityWrapper<UserAR>()
                        .like("name", "listen")
                        .between("age", 1, 30)
        ).getRecords();
        System.out.println("size = " + userList.size());
    }
}
