package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;



@DisplayName("Monitoring of different class types")
public class MultiThread extends LocalTestConfig{

    @DisplayName("Test Suite operate Multi Thread Classes")
    @Test
    public void multithreadSuites() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.MULTI_THREAD);
        Thread.sleep(1500);
    }

}
