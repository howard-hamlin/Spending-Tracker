package Utils;

import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class TEmulatorUtils {

    private static final String DEFAULT_TASK_ID = "1";
    private static final String DEFAULT_TEST_SUITE_ID = "2";

    public static void startEmulatorWithDefaultParams() {
        startEmulatorWithParameters("0", DEFAULT_TASK_ID, DEFAULT_TEST_SUITE_ID, "execId", 2L);
    }

    public static void startEmulatorWithParameters (String tenantId, String tarTaskId, String testSuiteId, String taskExecutionId, Long appVersionId) {
        String url = Endpoints.START_EMULATOR_URL.replace(Endpoints.TAR_TASK_ID_VAR, tarTaskId).replace(Endpoints.TEST_SUITE_ID_VAR, testSuiteId);

        given().params("tenantId", tenantId,"executionId", taskExecutionId, "appVersionId",appVersionId)
                .when().get(url).then().statusCode(HttpStatus.SC_OK);
    }

    public static void stopEmulatorWithDefaultParams() {
        stopEmulatorWithParameters("0", DEFAULT_TASK_ID, DEFAULT_TEST_SUITE_ID, "execId", 2L);
    }

    public static void stopEmulatorWithParameters (String tenantId, String tarTaskId, String testSuiteId, String taskExecutionId, Long appVersionId) {
        String url = Endpoints.STOP_EMULATOR_URL.replace(Endpoints.TAR_TASK_ID_VAR, tarTaskId).replace(Endpoints.TEST_SUITE_ID_VAR, testSuiteId);

        given().params("tenantId", tenantId,"executionId", taskExecutionId, "appVersionId",appVersionId)
                .when().get(url).then().statusCode(HttpStatus.SC_OK);
    }

    public static EmulatorResponse getMonitoredClasses () {
        String url = Endpoints.GET_COVERAGE_DATA_URL.replace(Endpoints.TAR_TASK_ID_VAR, DEFAULT_TASK_ID);
        return get(url).as(EmulatorResponse.class);
    }

    public static void executeOperation(Library library){
        String url = Endpoints.DUMMY_APPLICATION_CLASS_URL_ENTITY_PATH.replace(Endpoints.ID_VAR, library.getId());
        when().get(url).then().statusCode(HttpStatus.SC_OK);
    }

    public static void executeAllOperations(){
        when().get(Endpoints.DUMMY_APP_lIBRAHIM_URL).then().statusCode(HttpStatus.SC_OK);
    }

    public static boolean isContainsFile(List<EmulatorResponse.File> list, String fileName){
        return list.stream().anyMatch(file -> file.getFilename().equals(fileName));
    }

    public static List<String> getAllFilesNames(List<EmulatorResponse.File> list){
        return list.stream().map(EmulatorResponse.File:: getFilename).collect(Collectors.toList());
    }

    private static Optional<EmulatorResponse.File> getFileFromFilesList(List<EmulatorResponse.File> files, String fileName){
          Optional<EmulatorResponse.File> file = files.stream()
                .filter(f -> (fileName).equals(f.getFilename()))
                .findFirst();
          return file;
    };

    public static boolean isMonitoredFilesContainsExpectedFiles(List<String> files, List<String> expectedFiles){
        for (int i = 0; i < expectedFiles.size(); i++){
            if (files.contains(expectedFiles.get(i))){
                return true;
            }
        }
        return false;
    }

    public static int getVisits(List<EmulatorResponse.File> files, String fileName){
        Optional<EmulatorResponse.File> file = getFileFromFilesList(files, fileName);
        return file.isPresent() ? file.get().getVisits() : -1;
    }

    public static int getPackageIndexByName(String packageName){
        EmulatorResponse response = getMonitoredClasses();
        return response.getPackages().size() > 0 ?  response.getPackages().indexOf(packageName) : -1;
    }

    public static int getPack(List<EmulatorResponse.File> files, String fileName){
        Optional<EmulatorResponse.File> file = getFileFromFilesList(files, fileName);
        return file.isPresent() ? file.get().getPack() : -1;
    };
}
