package Utils;

import static rest.assured.shared.config.TestConfig.sutDetails;

public interface Endpoints {

    String TAR_TASK_ID = "tarTaskId";
    String TAR_TASK_ID_VAR = "{" + TAR_TASK_ID  +"}";

    String TEST_SUITE_ID = "testSuiteId";
    String TEST_SUITE_ID_VAR = "{" + TEST_SUITE_ID  +"}";

    String START_EMULATOR_URL = "_/tar-task/" + TAR_TASK_ID_VAR + "/test-suite/" + TEST_SUITE_ID_VAR + "/start";

    String STOP_EMULATOR_URL = "_/tar-task/" + TAR_TASK_ID_VAR + "/test-suite/" + TEST_SUITE_ID_VAR + "/stop";

    String GET_COVERAGE_DATA_URL = "_/tar-task/" + TAR_TASK_ID_VAR + "/coverage-data";

    String DUMMY_APP_lIBRAHIM_URL = "http://" + sutDetails.getHost() + ":" + sutDetails.getPort() + "/dummy/api/libraries";

    String ID_VAR = "{id}";

    String DUMMY_APPLICATION_CLASS_URL_ENTITY_PATH = Endpoints.DUMMY_APP_lIBRAHIM_URL + "/" + ID_VAR;

}
