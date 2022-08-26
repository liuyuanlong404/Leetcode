package com.rose.functional.test;

import com.rose.entity.Student;
import com.rose.functional.TestSupplier;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created on 2022/8/12 16:31
 *
 * @author Lakers
 */
@Data
public class Test {

    public static void main(String[] args) {

        // Consumer Test
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer2 = System.out::println;
        consumer1.andThen(consumer2).accept("Lakers");

        // Supplier Test
        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();

        consumer1.accept(maxBy(() -> {
            List<String> stringList = Arrays.asList("1", "11", "111", "1111");
            return stringList.stream().max(Comparator.comparing(String::length)).orElseThrow(() -> new RuntimeException("数据不存在！"));
        }));

        //
        Predicate<String> predicate = s -> s.length() > 5;
        boolean test = predicate.negate().and("1"::equals).test("1");
        System.out.println(test);
    }

    public static <T> T maxBy(TestSupplier<T> supplier){
        return supplier.get();
    }

}
