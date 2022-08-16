package com.rose.functional;

/**
 * Created on 2022/8/12 16:29
 *
 * @author Lakers
 */
@FunctionalInterface
public interface TestFunction<T, R> {
    /**
     * 测试方法
     *
     * @param t 参数
     * @return T
     */
    R apply(T t);
}
