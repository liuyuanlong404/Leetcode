package com.rose.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rose.entity.Student;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 2022/3/19 11:46
 *
 * @author Lakers
 */
public class JsonTest {

    public static void main(String[] args) {
        Student student = new Student(10, "1", 20, BigDecimal.ONE, LocalDateTime.now());
        Student student1 = new Student(20, "admin", 19, BigDecimal.TEN, LocalDateTime.now());
        Student student2 = new Student(20, "ada", 18, BigDecimal.ONE, LocalDateTime.now());
        Student student3 = new Student(20, "ada1", 18, BigDecimal.ONE, LocalDateTime.now());

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);

//        Comparator<Student> comparator = Comparator.comparing(Student::getId).thenComparing(Student::getAge).reversed();
//        list.sort(comparator);

        list.sort(((o1, o2) -> {
            if (o1.getId().equals(o2.getId())){
                if (o1.getAge().equals(o2.getAge())){
                    return o1.getMoney().subtract(o2.getMoney()).setScale(0, BigDecimal.ROUND_UP).intValue();
                }

                return o2.getAge() - o1.getAge();
            }

            return o2.getId() - o1.getId();
        }));

        list.forEach(System.out::println);


    }
}
