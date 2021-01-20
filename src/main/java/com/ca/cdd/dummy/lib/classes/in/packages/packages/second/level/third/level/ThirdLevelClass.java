package com.ca.cdd.dummy.lib.classes.in.packages.packages.second.level.third.level;

import com.ca.cdd.dummy.lib.Library;

public class ThirdLevelClass extends Library {

    private static String NAME = "ThirdLevelClass";


    public String thirdLeveLClass () {

        return "Class in Package Tree Third Hierarchy";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
