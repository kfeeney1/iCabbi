import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class postAPI {

    public static void postCreateUser(String url) {
        String name = "Kev";
        String job = "Tester";

        String requestBody = "{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"job\": \""+job+"\"\n}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract().response();

        int statusCode = response.statusCode();
        String responseName = response.path("name");
        String responseJob = response.path("job");

        Assert.assertEquals(201, statusCode);
        Assert.assertEquals(name, responseName);
        Assert.assertEquals(job, responseJob);

    }
}