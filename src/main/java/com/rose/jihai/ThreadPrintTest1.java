package com.rose.jihai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2022/8/26 17:10
 *
 * @author Lakers
 */
public class ThreadPrintTest1 {

    private static int status = 0;

    private static int count = 1;

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Thread t1 = new Thread(() -> {
            while (count <= 100) {
                synchronized (LOCK) {
                    if (status == 0 && count <= 100) {
                        System.out.println("A");
                        count++;
                        status = 1;
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (count <= 100) {
                synchronized (LOCK) {
                    if (status == 1 && count <= 100) {
                        System.out.println("B");
                        count++;
                        status = 2;
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (count <= 100) {
                synchronized (LOCK) {
                    if (status == 2 && count <= 100) {
                        System.out.println("C");
                        count++;
                        status = 0;
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
