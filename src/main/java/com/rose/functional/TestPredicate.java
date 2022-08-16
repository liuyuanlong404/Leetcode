package com.rose.functional;

/**
 * Created on 2022/8/12 16:37
 *
 * @author Lakers
 */
@FunctionalInterface
public interface TestPredicate<T> {

    /**
     * 测试方法
     *
     * @param t 参数
     * @return boolean
     */
    boolean test(T t);
}
