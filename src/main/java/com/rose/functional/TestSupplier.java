package com.rose.functional;

/**
 * Created on 2022/8/12 16:29
 *
 * @author Lakers
 */
@FunctionalInterface
public interface TestSupplier<T> {

    /**
     * 测试方法
     *
     * @return T
     */
    T get();
}
