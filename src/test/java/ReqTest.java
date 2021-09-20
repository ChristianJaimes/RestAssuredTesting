import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class ReqTest {
    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(200).

    }
}
