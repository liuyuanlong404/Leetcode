package com.rose.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.system.SystemUtil;
import com.alibaba.fastjson.JSONObject;
import com.rose.entity.Student;
import com.alibaba.fastjson.JSON;
import com.rose.entity.SysTransactionSetting;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import cn.hutool.core.bean.BeanUtil;

import javax.imageio.stream.IIOByteBuffer;

/**
 * Created on 2021/9/15 16:31
 * @author Rose
 */
public class StudentTest {

    public static void main(String[] args) {
//        List<Student> students = Arrays.asList(
//                new Student(1,"张三",20,BigDecimal.ONE,LocalDateTime.now().plusMinutes(1)),
//                new Student(2,"李四",21,BigDecimal.TEN,LocalDateTime.now().plusMinutes(-2)),
//                new Student(3,"王五",22,BigDecimal.ONE,LocalDateTime.now().plusMinutes(3)));
//        BigDecimal bigDecimal = students.stream().filter(t -> t.getCreateTime().isAfter(LocalDateTime.now()))
//                .map(t -> t.getMoney()).reduce(BigDecimal::add).get();
//        System.out.println(bigDecimal);
//        students.forEach(System.out::println);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date());
        System.out.println(new DateTime());
        System.out.println(LocalDateTime.now());
        System.out.println(Calendar.getInstance().getTime());
        Duration duration = Duration.between(LocalDateTime.now().plusDays(-1),LocalDateTime.now());
        if (duration.toDays() > 1){
            System.out.println("10");
        }
    }
}
