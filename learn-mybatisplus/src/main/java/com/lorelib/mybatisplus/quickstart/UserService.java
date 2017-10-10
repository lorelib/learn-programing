package com.lorelib.mybatisplus.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author listening
 * @description
 * @date 2017-10-09 11:35
 * @since 1.1
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int insert() {
        int result = 0;
        User user = new User();
        user.setName("Tom");
        result = userMapper.insert(user);
        assert result == 1 : "插入数据失败";
        return user.getId();
    }
}
