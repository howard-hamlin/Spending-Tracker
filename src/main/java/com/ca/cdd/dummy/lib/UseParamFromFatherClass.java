package com.ca.cdd.dummy.lib;



public class UseParamFromFatherClass extends Library {

    private static String NAME = "UseParamFromFatherClass";

    public String printParam() {

        ClassWithParamUsedByOtherOnly a = new ClassWithParamUsedByOtherOnly();
        return a.toUseFromExtendClass;
    }
     
    @Override
    public String getName() {
        return NAME;
    }
}
