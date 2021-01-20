package com.ca.cdd.dummy.lib.classes.in.packages.packages.second.level;

public class Thread4UnderPkgSecondLevel implements Runnable {
    @Override
    public void run() {
        System.out.println("I am Thread 4");
    }

    public static String getName() {return "Thread4UnderPkgSecondLevel";
    }
}
