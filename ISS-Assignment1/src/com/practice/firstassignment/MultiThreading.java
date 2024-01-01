/**
 * 
 */
package com.practice.firstassignment;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author Shrikant_Bhadgaonkar
 * 8. Multithreading
 */



public class MultiThreading {
    private volatile boolean flag = true;
    private final Object lock = new Object();

    // Non-synchronized method
    public void flipFlag() {
        flag = !flag;
    }

    // Synchronized method
    synchronized public void flipFlagSyn() {
        flag = !flag;
    }

    // Block synchronized method
    public void flipFlagSyn(int id) {
        System.out.println("Executing thread id " + id);
        synchronized (lock) {
            flag = !flag;
        }
    }

    public boolean getFlag() {
    	synchronized(lock) {
        return flag;
    	}
    }

    public static void main(String[] args) throws ExecutionException {
        MultiThreading obj = new MultiThreading();

        // Creating a single-threaded executor for sequential execution
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        ExecutorService executorService2= Executors.newFixedThreadPool(2);
        ExecutorService executorService3 = Executors.newFixedThreadPool(2);

        try {
            System.out.println("Flipping flag without synchronization: ");
            // Using invokeAll for sequential execution
            List<Future<Void>> futures1 = executorService1.invokeAny(List.of(
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service1 output by t1: " + obj.getFlag());
                        obj.flipFlag();
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service1 output by t2: " + obj.getFlag());
                        obj.flipFlag();
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service1 output by t3: " + obj.getFlag());
                        obj.flipFlag();
                        return null;
                    }
            ));

            // Getting the size of the thread pool
            System.out.println(executorService1);
            System.out.println("Current flag status: "+obj.getFlag());
            System.out.println("Flipping the flag with method synchronization: ");
            List<Future<Void>> futures2 = executorService2.invokeAny(List.of(
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service2 output by t1: " + obj.getFlag());
                        obj.flipFlagSyn();
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service2 output by t2: " + obj.getFlag());
                        obj.flipFlagSyn();
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service2 output by t3: " + obj.getFlag());
                        obj.flipFlagSyn();
                        return null;
                    }
            ));
            System.out.println("Current flag status: "+obj.getFlag());
            System.out.println("Flipping the flag with block synchronization: ");
            List<Future<Void>> futures3 = executorService3.invokeAny(List.of(
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service3 output by t1: " + obj.getFlag());
                        obj.flipFlagSyn(1);
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service3 output by t2: " + obj.getFlag());
                        obj.flipFlagSyn(2);
                        return null;
                    },
                    () -> {
                        //Thread.sleep(1000);
                        System.out.println("Service3 output by t3: " + obj.getFlag());
                        obj.flipFlagSyn(3);
                        return null;
                    }
            ));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService1.shutdown();
            executorService2.shutdown();
            executorService3.shutdown();
            System.out.println("Current flag status: "+obj.getFlag());
        }
    }
}


