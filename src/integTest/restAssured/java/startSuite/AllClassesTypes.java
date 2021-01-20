package startSuite;

import Utils.LocalTestConfig;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Monitoring of different class types")
public class AllClassesTypes extends LocalTestConfig {

    @DisplayName("Operate All classes in dummy Application")
    @Test
    public void allLibrariesExists() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeAllOperations();

        Thread.sleep(1500);
    }
}

// ga71aaa
