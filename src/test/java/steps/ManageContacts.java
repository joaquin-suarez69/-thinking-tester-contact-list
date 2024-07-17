package steps;

import definitions.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Contact;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static steps.BaseTest.contacts;


public class ManageContacts extends UIInteractions  {
    @Steps
    StepDefinition stepDefinition = new StepDefinition();
    @Given("user logs in the system")
    public void user_logs_in_the_system(){
        BaseTest.logger.info("User email "+BaseTest.user.getEmail());
        stepDefinition.login(BaseTest.user);
    }

    @When("user tries to {string} contact {int}")
    public void user_tries_to_method(String action, int index) {
        Contact contact = contacts.get(index-1);
        switch(action) {
            case "create":
                stepDefinition.addContact(contact);
                assertTrue(stepDefinition.validateNewContactInList(contact));
                BaseTest.logger.info("create contact");
                break;
            case "delete":
                stepDefinition.deleteContact(contact);
                BaseTest.logger.info("Update contact");
                break;

        }
    }
    @When("user tries to update contact {int} with contact {int} information")
    public void user_tries_to_update_contact(int index, int newIndex) {
        stepDefinition.updateContact(contacts.get(index-1), contacts.get(newIndex-1));
        BaseTest.logger.info("Update contact");
    }

    @Then("contact {int} is present on the contacts list")
    public void new_contact_present_on_list(int index){
        assertTrue(stepDefinition.validateNewContactInList(contacts.get(index-1)));
    }

    @Then("contact {int} has contact {int} information")
    public void updated_contact_present_on_list(int index, int newIndex){
        assertTrue(stepDefinition.validateNewContactInList(contacts.get(newIndex-1)));
    }
    @Then("contact {int} is not present on the contacts list")
    public void new_contact_not_present_on_list(int index){
        assertFalse(stepDefinition.validateNewContactInList(contacts.get(index-1)));
    }
}
