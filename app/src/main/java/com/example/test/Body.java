package com.example.test;

/**
 * @Author: Guanam
 * @Date: 19/8/2024 - 08 - 19 -上午12:39
 * @Version: 1.0
 */
public class Body {
    private String name ;
    private int age ;

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

    public Body(String name, int age) {
        this.name = name;
        this.age = age;
    }
}