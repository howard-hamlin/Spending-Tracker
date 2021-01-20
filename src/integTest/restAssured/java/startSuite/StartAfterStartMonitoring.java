package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class StartAfterStartMonitoring extends LocalTestConfig{

    @DisplayName("Agent accept Start After Start Without Stop in the middle")
    @Test
    public void sendStartRightAfterStart() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.COMICS_LIBRARY);

        TEmulatorUtils.executeOperation(Library.CENTRAL_LIBRARY);
        Thread.sleep(1500);
    }
}
// count111
