package startSuite;

import Utils.Library;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import Utils.LocalTestConfig;

@DisplayName("Monitoring of different class types")
public class ValdateVisitsCalculation extends LocalTestConfig{

    @DisplayName("Validate Files Visits calculation")
    @Test
    public void visitsNumberIsCorrect() throws InterruptedException {

        Thread.sleep(1500);
        int numOfVisitForComics =10;
        int numOfVisitForExactScience =5;
        runOperationXtimes(numOfVisitForComics, Library.COMICS_LIBRARY);
        runOperationXtimes(numOfVisitForExactScience, Library.EXACTSCIENCES_LIBRARY);
        Thread.sleep(1500);
    }

    private void runOperationXtimes (int numOfItr, Library operation) {
        for (int i=0; i < numOfItr; i++) {
            TEmulatorUtils.executeOperation(operation);
        }
    }
}
// ga71
