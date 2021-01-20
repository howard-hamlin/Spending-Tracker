package Utils;

public enum Library {

    CENTRAL_LIBRARY("0", "CentralLibrary.java"),
    COMICS_LIBRARY("1", "ComicsLibrary.java"),
    EXACTSCIENCES_LIBRARY("2" , "ExactSciencesLibrary.java"),
    INNERC_LASS_LIBRARY("3" , "InnerClassCallToClass.java"),
    IMPLEMETN_INTERFACE("4" , "ImplementInterface.java"),
    ANONYMOUS_CLASS("5" , "AnonymousClass.java"),
    FIRST_LEVEL_PKG_CLASS("6" , "OneLevelClass.java"),
    SECOND_LEVEL_PKG_CLASS("7" , "SecondLevelClass.java"),
    THIRD_LEVEL_PKG_CLASS("8" , "ThirdLevelClass.java"),
    MULTI_THREAD("10", "MainThread.java"),
    FAIL_SCENARIO("11", "FailTestSuite.java");


    private String id;
    private String name;

    Library(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
