package com.rose.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2022/8/29 14:20
 *
 * @author Lakers
 */
public class ThreadDemo {

    public static void main(String[] args) {
//        // 1. 创建线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        List<Future<String>> futures = new ArrayList<>();
//        for (Integer key : list) {
//            // 2. 提交任务
//            Future<String> future = executorService.submit(() -> {
//                // 睡眠一秒，模仿处理过程
//                Thread.sleep(1000L);
//                return "结果" + key;
//            });
//            futures.add(future);
//        }
//
//        // 3. 获取结果
//        for (Future<String> future : futures) {
//            try {
//                String result = future.get();
//                System.out.println(result);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        executorService.shutdown();

        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Integer key : list) {
            // 2. 提交任务
            CompletableFuture.supplyAsync(() -> {
                // 睡眠一秒，模仿处理过程
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException ignored) {
                }
                return "结果" + key;
            }, executorService).whenCompleteAsync((result, exception) -> {
                // 3. 获取结果
                System.out.println(result);
            });
        }

        executorService.shutdown();
        // 由于whenCompleteAsync获取结果的方法是异步的，所以要阻塞当前线程才能输出结果
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
