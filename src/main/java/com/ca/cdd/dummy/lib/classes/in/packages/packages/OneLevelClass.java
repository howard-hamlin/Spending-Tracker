package com.ca.cdd.dummy.lib.classes.in.packages.packages;

import com.ca.cdd.dummy.lib.Library;

public class OneLevelClass extends Library {

    private static String NAME = "OneLevelClass";

    public String oneLevelClass () {

        return "Class in Package Tree First Hierarchy";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
