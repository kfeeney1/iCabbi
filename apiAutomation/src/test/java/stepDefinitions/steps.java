package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
    @Given("this is a given")
    public void thisIsAGiven() {
        System.out.println("Given");
    }

    @When("this is a when")
    public void thisIsAWhen() {
        System.out.println("When");

    }

    @Then("this is a then")
    public void thisIsAThen() {
        System.out.println("Then");
    }
}
