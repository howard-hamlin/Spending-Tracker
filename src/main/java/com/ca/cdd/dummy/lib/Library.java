package com.ca.cdd.dummy.lib;

public abstract class Library {
    private static String SUFFIX = "Library";

    public String toUseFromExtendClass = "Param Call from extend Class";

    public abstract String getName();

    public String getType() {
        return getName() + SUFFIX;
    }
}
