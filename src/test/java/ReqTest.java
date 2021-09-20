import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class ReqTest {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
    }

    @Test
    public void loginTest(){
                given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("login")
                .then()
                .statusCode(HttpStatus.SC_OK)//codigo 200
                .body("token", notNullValue());

    }
    @Test
    public void getSingleUserTest(){
        given()
                .contentType(ContentType.JSON)
                .get("sers/2")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)//
                .body("data.id",equalTo(2));
    }
}
