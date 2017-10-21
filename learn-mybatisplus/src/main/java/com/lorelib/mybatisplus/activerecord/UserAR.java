package com.lorelib.mybatisplus.activerecord;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author listening
 * @description
 * @date 2017-10-09 10:33
 * @since 1.1
 */
@TableName("user")
public class UserAR extends Model<UserAR> {
    private Integer id;
    private String name;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
