package com.rose.functional;

/**
 * Created on 2022/8/12 16:29
 *
 * @author Lakers
 */
@FunctionalInterface
public interface TestConsumer<T> {
    /**
     * 测试方法
     *
     * @param t 参数
     */
    void accept(T t);
}
