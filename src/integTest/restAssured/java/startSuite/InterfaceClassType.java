package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class InterfaceClassType extends LocalTestConfig{

    @DisplayName("Test Suite operate class type Interface")
    @Test
    public void interfaceExistInFiles() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.IMPLEMETN_INTERFACE);
        Thread.sleep(1500);
    }

}
// 7.2
