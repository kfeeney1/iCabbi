import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.given;

public class getAPI {

    public static void getID(String url, String user) {
        String requestURL = url+user;

        System.out.println(requestURL);

        Response response = given()
                .get(requestURL)
                .then()
                .extract().response();

        int statusCode = response.statusCode();
        int id = response.path("data.id");
        System.out.println("The response status is "+statusCode);
        System.out.println("The id is "+id);

        Assert.assertEquals(200, statusCode);
        Assert.assertEquals(2, id);
    }
}