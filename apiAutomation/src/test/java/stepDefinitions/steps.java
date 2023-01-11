package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class steps {
    private static int returnedStatusCode;
    private static String returnedID;
    private static String responseName;
    private static String responseJob;

    public static void setReturnedStatusCode(int returnedStatusCode) {
        steps.returnedStatusCode = returnedStatusCode;
    }

    public static void setReturnedID(String returnedID) {
        steps.returnedID = returnedID;
    }

    public static void setResponseName(String responseName) {
        steps.responseName = responseName;
    }
    public static void setResponseJob(String responseJob) {
        steps.responseJob = responseJob;
    }

    @Given("I call get on users for {string}")
    public void iCallGetOnUsersFor(String user) {
        String requestURL = "https://reqres.in/api/users/" + user;

        System.out.println(requestURL);

        Response response = given()
                .get(requestURL)
                .then()
                .extract().response();

        setReturnedStatusCode(response.statusCode());

        returnedID = response.path("data.id").toString();
    }

    @Then("I will be returned a status code {string}")
    public void iWillBeReturnedAStatusCode(String expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, Integer.toString(returnedStatusCode));
    }

    @And("I will be returned an ID {string}")
    public void iWillBeReturnedAnID(String expectedID) {
        Assert.assertEquals(expectedID, returnedID);
    }

    @Given("I create a user name {string} and Job {string}")
    public void iCreateAUserNameAndJob(String name, String job) {
        String requestURL = "https://reqres.in/api/users/";

        String requestBody = "{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"job\": \""+job+"\"\n}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(requestURL)
                .then()
                .extract().response();

        setReturnedStatusCode(response.statusCode());
        setResponseName(response.path("name"));
        setResponseJob(response.path("job"));
    }

    @And("I will be returned a name {string}")
    public void iWillBeReturnedAName(String expectedName) {
        Assert.assertEquals(expectedName, responseName);
    }

    @And("I will be returned a job {string}")
    public void iWillBeReturnedAJob(String expectedJob) {
        Assert.assertEquals(expectedJob, responseJob);
    }

}
