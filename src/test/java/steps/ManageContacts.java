package steps;

import definitions.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Contact;
import models.User;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ManageContacts {
    WebDriver driver = BaseTest.driver;
    StepDefinition stepDefinition = new StepDefinition();
    @Given("user {string} logs in the system")
    public void user_logs_in_the_system(String user) throws Throwable {

        System.out.println("Given step user "+user);
        stepDefinition.login(new User("test@account.com","myPassword"));
    }

    @When("^user tries to create a contact$")
    public void user_tries_to_create_contact() throws Throwable {
        stepDefinition.addContact(new Contact("test 4","test 4"));
        System.out.println("When step");
    }


    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        System.out.println("Then step");
    }
}
