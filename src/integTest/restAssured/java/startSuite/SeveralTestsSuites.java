package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class SeveralTestsSuites extends LocalTestConfig{

    @DisplayName("Send Several Tests Suites")
    @Test
    public void sentSeveralTestsSuites() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.COMICS_LIBRARY);

        TEmulatorUtils.executeOperation(Library.ANONYMOUS_CLASS);

        TEmulatorUtils.executeOperation(Library.INNERC_LASS_LIBRARY);

        runOperationXtimes(2, Library.SECOND_LEVEL_PKG_CLASS);
        Thread.sleep(1500);
    }

    private void runOperationXtimes (int numOfItr, Library operation) {
        for (int i=0; i < numOfItr; i++) {
            TEmulatorUtils.executeOperation(operation);
        }
    }
}
// aaaa
