package com.rose.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author Lakers
 * @date 2022-04-18
 */
public class StreamUtil {

    /**
     * @param collection 集合
     * @param mapper     结果映射
     * @param <T>        集合类型
     * @param <R>        结果类型
     */
    public static <T, R> List<R> toList(Collection<T> collection, Function<? super T, ? extends R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * @param collection 集合
     * @param mapper     结果映射
     * @param <T>        集合类型
     * @param <R>        结果类型 去重
     */
    public static <T, R> List<R> toListDistinct(Collection<T> collection, Function<? super T, ? extends R> mapper) {
        return collection.stream().map(mapper).distinct().collect(Collectors.toList());
    }


    /**
     * @param collection 集合
     * @param keyMapper  key映射
     * @param <T>        集合类型
     * @param <K>        key类型
     */
    public static <T, K> Map<K, T> toMap(Collection<T> collection,
                                         Function<? super T, ? extends K> keyMapper) {
        return toMap(collection, keyMapper, Function.identity());
    }

    /**
     * @param collection  集合
     * @param keyMapper   key映射
     * @param valueMapper value映射
     * @param <T>         集合类型
     * @param <K>         key类型
     * @param <V>         value类型
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection,
                                            Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends V> valueMapper) {
        return toMap(collection, keyMapper, valueMapper, (v1, v2) -> v1);
    }

    /**
     * @param collection    集合
     * @param keyMapper     key映射
     * @param valueMapper   value映射
     * @param mergeFunction key重复时合并操作
     * @param <T>           集合类型
     * @param <K>           key类型
     * @param <V>           value类型
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection,
                                            Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends V> valueMapper,
                                            BinaryOperator<V> mergeFunction) {
        return collection.stream().collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));
    }

    /**
     * @param collection 集合
     * @param classifier 分组key
     * @param <T>        集合类型
     * @param <K>        key类型
     * @return Map<K, List < T>>
     */
    public static <T, K> Map<K, List<T>> groupingBy(Collection<T> collection, Function<? super T, ? extends K> classifier) {
        return groupingBy(collection, classifier, Collectors.toList());
    }

    /**
     * @param collection 集合
     * @param classifier key
     * @param downstream 收集器
     * @param <T>        集合类型
     * @param <K>        key类型
     * @param <A>        收集器类型
     * @param <D>        value类型
     * @return Map<K, D>
     */
    public static <T, K, A, D> Map<K, D> groupingBy(Collection<T> collection,
                                                    Function<? super T, ? extends K> classifier,
                                                    Collector<? super T, A, D> downstream) {
        return groupingBy(collection, classifier, HashMap::new, downstream);
    }

    /**
     * @param collection 集合
     * @param classifier key
     * @param mapFactory mapFactory
     * @param downstream 收集器
     * @param <T>        集合类型
     * @param <K>        key类型
     * @param <D>        value类型
     * @param <A>        收集器类型
     * @param <M>        mapFactory类型
     * @return Map<K, D>
     */
    public static <T, K, D, A, M extends Map<K, D>> M groupingBy(Collection<T> collection,
                                                                 Function<? super T, ? extends K> classifier,
                                                                 Supplier<M> mapFactory,
                                                                 Collector<? super T, A, D> downstream) {
        return collection.stream().collect(Collectors.groupingBy(classifier, mapFactory, downstream));
    }
}
