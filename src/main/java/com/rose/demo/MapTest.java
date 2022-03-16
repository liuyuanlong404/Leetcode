package com.rose.demo;

import com.rose.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 2022/3/14 16:04
 *
 * @author Lakers
 */
public class MapTest {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){

            Student student;
            if (i == 1){
                student = new Student(i, "name", null, null,null);
            }else {
                student = new Student(i, "name" + i, null, null, null);
            }
            list.add(student);
        }

        list = list.subList(0,10);
        list.forEach(System.out::println);

        long startTime = System.currentTimeMillis();
        list.stream().filter(t -> "name".equals(t.getName())).findFirst().get();
        long endTime = System.currentTimeMillis();
        System.out.println("时间1： " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        list.stream().filter(t -> "name".equals(t.getName())).findAny().get();
        endTime = System.currentTimeMillis();
        System.out.println("时间2： " + (endTime - startTime));
    }

    private static void streamTest(List<Student> list) {

        String name = "name";
        int size = list.size();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            int finalI = i;
            list.stream().filter(t -> t.getName().equals(name + finalI)).findAny().get();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("stream时间:" + (endTime - startTime));

    }

    private static void mapTest(List<Student> list) {

        long startTime = System.currentTimeMillis();
        Map<String, Student> studentDict = list.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        list.forEach(student -> studentDict.get(student.getName()));
        long endTime = System.currentTimeMillis();

        System.out.println("map时间:" + (endTime - startTime));

    }
}
