package com.rose.jihai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2022/8/19 10:21
 *
 * @author Lakers
 */
public class ThreadPrintTest {

    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        Condition printAcondition = REENTRANT_LOCK.newCondition();
        Condition printBcondition = REENTRANT_LOCK.newCondition();
        Condition printCcondition = REENTRANT_LOCK.newCondition();

        executorService.execute(() -> new PrintRunnable(REENTRANT_LOCK, printAcondition, printBcondition, 34, 'A').run());
        executorService.execute(() -> new PrintRunnable(REENTRANT_LOCK, printBcondition, printCcondition, 33, 'B').run());
        executorService.execute(() -> new PrintRunnable(REENTRANT_LOCK, printCcondition, printAcondition, 33, 'C').run());
//        Thread t1 = new Thread(new PrintRunnable(REENTRANT_LOCK, printAcondition, printBcondition, 34, 'A'));
//        Thread t2 = new Thread(new PrintRunnable(REENTRANT_LOCK, printBcondition, printCcondition, 33, 'B'));
//        Thread t3 = new Thread(new PrintRunnable(REENTRANT_LOCK, printCcondition, printAcondition, 33, 'C'));
//
//        t1.start();
//        t2.start();
//        t3.start();
    }

    public static class PrintRunnable implements Runnable {

        private final ReentrantLock reentrantLock;

        private final Condition currentCondition;

        private final Condition nextCondition;

        private final Integer count;

        private final Character character;

        private Integer index = 0;

        public PrintRunnable(ReentrantLock reentrantLock, Condition currentCondition, Condition nextCondition, Integer count, Character character) {
            this.reentrantLock = reentrantLock;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
            this.count = count;
            this.character = character;
        }

        @Override
        public void run() {
            do {
                reentrantLock.lock();
                try {
                    if (index <= count) {
                        System.out.println(character);
                        index++;
                    }
                    nextCondition.signal();
                    currentCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }

            } while (index <= count);
        }
    }

}
