package com.ca.cdd.dummy.lib;

public class ImplementInterface extends Library implements InterfaceClass {

    private static String NAME = "ImplementInterface";

    @Override
    public Integer useAbstractInInterface() {
        return 10;
    }

    @Override
    public String interfaceStingMethod() {
        return "implementing interface string method";
    }


    @Override
    public String getName() {
        return NAME;
    }
}
