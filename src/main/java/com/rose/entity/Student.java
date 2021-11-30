package com.rose.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created on 2021/9/15 16:28
 *
 * @author Rose
 */
@Data
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private BigDecimal money;

    private LocalDateTime createTime;

    public Student(Integer id, String name, Integer age, BigDecimal money ,LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
        this.createTime = createTime;
    }
}
