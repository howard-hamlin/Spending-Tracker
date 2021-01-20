package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class InnerClassType extends LocalTestConfig{

    @DisplayName("Test Suite operate class type Inner Class")
    @Test
    public void innerClassExistInFiles() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.INNERC_LASS_LIBRARY);
        Thread.sleep(1500);
    }
}
// 7.1a
