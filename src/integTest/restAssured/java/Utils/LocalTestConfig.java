package Utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import rest.assured.shared.config.SUTDetails;
import rest.assured.shared.config.TestConfig;

public class LocalTestConfig extends TestConfig {

    @BeforeClass
    public static void setup() {
        sutDetails = SUTDetails.getInstance();
        requestSpec = (new RequestSpecBuilder()).setBaseUri(sutDetails.getScheme() + "://" + sutDetails.getHost()).setPort(sutDetails.getPort()).setBasePath(sutDetails.getContextSuffix()).setContentType(ContentType.JSON).setAccept(ContentType.JSON).addFilter(new AllureRestAssured()).build();
        RestAssured.requestSpecification = requestSpec;
        responseSpec = (new ResponseSpecBuilder()).expectStatusCode(200).build();
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
    }

    @AfterClass
    public static void teardown() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
    }
}
