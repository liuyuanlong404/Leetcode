package com.rose.jihai;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2022/8/19 10:21
 *
 * @author Lakers
 */
public class ThreadPrintTest {


    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition printAcondition = reentrantLock.newCondition();
        Condition printBcondition = reentrantLock.newCondition();
        Condition printCcondition = reentrantLock.newCondition();

        Thread t1 = new Thread(new PrintRunnable(reentrantLock, printAcondition, printBcondition, 34, 'A'));
        Thread t2 = new Thread(new PrintRunnable(reentrantLock, printBcondition, printCcondition, 33, 'B'));
        Thread t3 = new Thread(new PrintRunnable(reentrantLock, printCcondition, printAcondition, 33, 'C'));

        t1.start();
        t2.start();
        t3.start();
    }

    public static class PrintRunnable implements Runnable {

        private ReentrantLock reentrantLock;

        private Condition currentCondition;

        private Condition nextCondition;

        private Integer count;

        private Character character;

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
