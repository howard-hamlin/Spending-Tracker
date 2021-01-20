package com.ca.cdd.dummy.lib.threadsclasses;

import com.ca.cdd.dummy.lib.Library;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("I am Thread 1");

    }

    public static String getName() {
        return "Thread1";
    }
}
