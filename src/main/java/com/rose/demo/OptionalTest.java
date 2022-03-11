package com.rose.demo;

import com.rose.entity.Student;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created on 2022/3/11 9:47
 *
 * @author Lakers
 *
 * JDK 1.8加入了 Optional 类。用于避免用if判空时出现空指针异常，它就是一个包裹着对象的容器。如果值存在则 isPresent()方法会返回 true，调用 get() 方法会返回该对象。
 *
 * JDK 提供三个静态方法来构造一个 Optional：
 *
 * 1.Optional.of(T value) 该方法通过一个非 null 的 value 来构造一个 Optional，返回的 Optional 包含了 value 这个值。对于该方法，传入的参数一定不能为 null，否则便会抛出 NullPointerException。
 *
 * 2.Optional.ofNullable(T value) 该方法和 of 方法的区别在于，传入的参数可以为 null，进行三目运算，判断传入的参数是否为 null，如果为 null 的话，返回的就是 Optional.empty()。
 *
 * 3.Optional.empty()该方法用来构造一个空的 Optional，即该 Optional 中不包含值 —— 其实底层实现还是 如果 Optional 中的 value 为 null 则该 Optional 为不包含值的状态，然后在 API 层面将 Optional 表现的不能包含 null 值，使得 Optional 只存在 包含值 和 不包含值 两种状态。
 */
public class OptionalTest {



    public static void main(String[] args) {

        Student s1 = null;

        Student s2 = new Student(1, "张三", 20, BigDecimal.TEN, LocalDateTime.now());

        Optional.ofNullable(s1).ifPresent(System.out::println);


        Student s3 = Optional.ofNullable(s1).orElse(s2);

        Student s4 = Optional.ofNullable(s1).orElseGet(() -> s2);

//        Optional.ofNullable(s1).orElseThrow(() -> new NullPointerException("空指针异常"));

        Optional<Integer> integer = Optional.ofNullable(s1).map(Student::getAge);

        Optional<Integer> integer1 = Optional.ofNullable(s1).flatMap(student -> Optional.ofNullable(student.getAge()));


    }
}
