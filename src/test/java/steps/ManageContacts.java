package steps;

import definitions.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Contact;
import models.User;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ManageContacts {
    WebDriver driver = BaseTest.driver;
    StepDefinition stepDefinition = new StepDefinition();
    @Given("user {string} logs in the system")
    public void user_logs_in_the_system(String user) throws Throwable {

        BaseTest.logger.info("Given step user "+user);
        stepDefinition.login(new User("test@account.com","myPassword"));
    }

    @When("^user tries to create a contact$")
    public void user_tries_to_create_contact() throws Throwable {
        stepDefinition.addContact(new Contact("test 4","test 4"));
        assertTrue(stepDefinition.validateNewContactInList(new Contact("test 4","test 4")));
        BaseTest.logger.info("create contact");
    }

    @When("^user tries to update a contact$")
    public void user_tries_to_update_contact() throws Throwable {
        stepDefinition.updateContact(new Contact("test 4","test 4"), new Contact("test 5","test 5"));
        assertTrue(stepDefinition.validateNewContactInList(new Contact("test 5","test 5")));
        BaseTest.logger.info("Update contact");
    }


    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        BaseTest.logger.info("Then step");
    }
}
