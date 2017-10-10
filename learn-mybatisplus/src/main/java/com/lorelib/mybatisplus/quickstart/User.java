package com.lorelib.mybatisplus.quickstart;

/**
 * @author listening
 * @description
 * @date 2017-10-09 10:33
 * @since 1.1
 */
public class User {
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
}
