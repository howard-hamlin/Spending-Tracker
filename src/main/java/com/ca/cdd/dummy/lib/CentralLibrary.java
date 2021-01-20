package com.ca.cdd.dummy.lib;

public class CentralLibrary extends Library {
    private static String NAME = "Central";

    @Override
    public String getName()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return NAME;
    }
    
}

// ga71
