import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostmanEchoTests {

    private static RequestSpecification requestSpec;

    @BeforeEach
    public void setUp() {
        requestSpec = given()
                .baseUri("https://postman-echo.com")
                .contentType(JSON);

        RestAssured.config = RestAssuredConfig.config().logConfig(LogConfig.logConfig()
                .enableLoggingOfRequestAndResponseIfValidationFails());
    }

    @Test
    public void testGetRequest() {
        Response response = given(requestSpec)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals("bar1", response.path("args.foo1"));
        assertEquals("bar2", response.path("args.foo2"));
    }

    @Test
    public void testPostRawTextRequest() {
        String jsonBody = "{\"test\":\"value\"}";

        Response response = given(requestSpec)
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("test", "value");

        Map<String, String> actualMap = response.path("data");

        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void testPostFormDataRequest() {
        Map<String, String> formData = new HashMap<>();
        formData.put("foo1", "bar1");
        formData.put("foo2", "bar2");

        Response response = given(requestSpec)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParams(formData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();
        assertEquals(formData, response.path("form"));
    }

    @Test
    public void testPutRequest() {
        String rawText = "This is a PUT test Aston";

        Response response = given(requestSpec)
                .body(rawText)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals(rawText, response.path("data"));
    }

    @Test
    public void testPatchRequest() {
        String rawText = "This is a PATCH test Aston";

        Response response = given(requestSpec)
                .body(rawText)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals(rawText, response.path("data"));
    }

    @Test
    public void testDeleteRequest() {
        String rawText = "This is a Delete test Aston";

        Response response = given(requestSpec)
                .body(rawText)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals(rawText, response.path("data"));
    }
}