package startSuite;

import Utils.Library;
import Utils.LocalTestConfig;
import Utils.TEmulatorUtils;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Monitoring of different class types")
public class ComicsLibraryClass extends LocalTestConfig{

    @DisplayName("Test Suite operate class with name ComicsLibrary")
    @Test
    public void comicsLibraryClassExist() throws InterruptedException {

        Thread.sleep(1500);
        TEmulatorUtils.executeOperation(Library.COMICS_LIBRARY);
     
        Thread.sleep(1500);
         
        
        
    }
}
