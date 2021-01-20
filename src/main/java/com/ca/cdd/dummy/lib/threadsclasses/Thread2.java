package com.ca.cdd.dummy.lib.threadsclasses;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("I am Thread 2");
    }

    public static String getName() {
        return "Thread2";
    }
}
