package com.ca.cdd.dummy.lib.threadsclasses;

public class Thread3 implements Runnable {
    @Override
    public void run() {
        System.out.println("I am Thread 3");
    }

    public static String getName() {
        return "Thread3";
    }
}
