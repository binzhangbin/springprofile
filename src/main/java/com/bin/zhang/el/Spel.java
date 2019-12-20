package com.bin.zhang.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * 测试使用SpringEL
 */
@Component
@RequestMapping("/el")
public class Spel implements Serializable {
    @Value("#{3}")
    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Spel{" +
                "age=" + age +
                '}';
    }
    @RequestMapping("/d")
    public void el(){
        System.out.println(this.getAge());
    }
}
