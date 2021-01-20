package com.ca.cdd.dummy.lib.threadsclasses;

import com.ca.cdd.dummy.lib.Library;
import com.ca.cdd.dummy.lib.Thread5UnkerPkgLib;
import com.ca.cdd.dummy.lib.classes.in.packages.packages.second.level.Thread4UnderPkgSecondLevel;

import java.util.Arrays;
import java.util.List;

public class MainThread extends Library {

    @Override
    public String toString() {
        return super.toString();
    }


    public MainThread() {

        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1);
        t1.start();

        Thread2 thread2 = new Thread2();
        Thread t2 = new Thread(thread2);
        t2.start();

        Thread3 thread3 = new Thread3();
        Thread t3 = new Thread(thread3);
        t3.start();

        Thread4UnderPkgSecondLevel thread4 = new Thread4UnderPkgSecondLevel();
        Thread t4 = new Thread(thread4);
        t4.start();

        Thread5UnkerPkgLib thread5 = new Thread5UnkerPkgLib();
        Thread t5 = new Thread(thread5);
        t5.start();

    }

    public static List<String> threadsList() {
        List<String> s = Arrays.asList(Thread1.getName(), Thread2.getName(), Thread3.getName(), Thread4UnderPkgSecondLevel.getName(), Thread5UnkerPkgLib.getName());
        return s;
    }

    @Override
    public String getName() {

        String l = "";
        for (String thread : threadsList()) {
            l = l.concat(thread + "\n");
        }
        return "Following Threads\\classes were run:\n\n" + l;
    }

}