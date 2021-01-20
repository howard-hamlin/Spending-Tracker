package com.ca.cdd.dummy.controllers;

import com.ca.cdd.dummy.lib.*;
import com.ca.cdd.dummy.lib.classes.in.packages.packages.OneLevelClass;
import com.ca.cdd.dummy.lib.classes.in.packages.packages.second.level.SecondLevelClass;
import com.ca.cdd.dummy.lib.classes.in.packages.packages.second.level.third.level.ThirdLevelClass;
import com.ca.cdd.dummy.lib.threadsclasses.MainThread;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("libraries")
@Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
public class LibraryController {


    @GET
    public String getLibraries() {
        Library[] libraries = { new CentralLibrary(), new ComicsLibrary(), new ExactSciencesLibrary(), new InnerClassCallToClass(), new InnerClassCallToClass.CallPrintStr(),
                                    new ImplementInterface(), new AnonymousClass(), new OneLevelClass(), new SecondLevelClass(), new ThirdLevelClass(), new UseParamFromFatherClass(),
                                    new MainThread(), new FailTestSuite()};
        StringBuffer sb = new StringBuffer("[ ");
        for (short i=0; i< libraries.length; i++) {
            sb.append("'").append(i).append("' : '").append(libraries[i].getType()).append("'");
            if (i != libraries.length-1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");

        return sb.toString(); // "[ 'Central', 'Comics', 'Exact sciences' ]";
    }

    @GET @Path("{id}")
    public String getLibraries(@PathParam("id") String id) {
        if ("0".equals(id)) {
            return new CentralLibrary().getType();
        }
        if ("1".equals(id)) {
            return new ComicsLibrary().getType();
        }
        if ("2".equals(id)) {
            return new ExactSciencesLibrary().getType();
        }
        if ("3".equals(id)) {
            InnerClassCallToClass.CallPrintStr callToInnerClass = new InnerClassCallToClass.CallPrintStr();
            return callToInnerClass.innerClass("Calling to Inner Class");
        }
        if ("4".equals(id)) {
            return new ImplementInterface().interfaceStingMethod();
        }
        if ("5".equals(id)) {
            AnonymousClass a = new AnonymousClass();
            return a.interfaceStingMethod();
        }
        if ("6".equals(id)) {
            return new OneLevelClass().oneLevelClass();
        }
        if ("7".equals(id)) {
            return new SecondLevelClass().secondLevelClass();
        }
        if ("8".equals(id)) {
            return new ThirdLevelClass().thirdLeveLClass();
        }
        if ("9".equals(id)) {
            return new UseParamFromFatherClass().printParam();
        }
        if ("10".equals(id)) {
            return new MainThread().getName();
        }
        if ("11".equals(id)) {
            return new FailTestSuite().getName();
        }

        return "I don't know what you are talking about? Give me a normal id!";
    }
    
    public static void main(String[] args) {
    }
}
