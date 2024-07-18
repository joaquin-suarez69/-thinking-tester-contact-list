package steps;

import definitions.StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import models.Contact;
import net.serenitybdd.annotations.Steps;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static steps.BaseTest.contacts;
import static steps.BaseTest.homePageTitle;


@Slf4j
public class ManageContacts {
    @Steps
    StepDefinition stepDefinition = new StepDefinition();
    @Given("user logs in the system")
    public void user_logs_in_the_system(){
        log.info("User email "+BaseTest.user.getEmail());
        stepDefinition.login(BaseTest.user);
    }

    @When("user {string} contact {int}")
    public void user_tries_to_method(String action, int index) {
        Contact contact = contacts.get(index-1);
        switch(action) {
            case "creates":
                stepDefinition.addContact(contact);
                assertTrue(stepDefinition.validateContactInList(contact));
                log.info("create contact");
                break;
            case "deletes":
                if(stepDefinition.deleteContact(contact)) {
                    log.info("Delete contact");
                } else {
                    fail("Unable to find the contact to delete");
                }
                break;
        }
    }
    @When("user updates contact {int} with contact {int} information")
    public void user_tries_to_update_contact(int index, int newIndex) {
        stepDefinition.updateContact(contacts.get(index-1), contacts.get(newIndex-1));
        log.info("Update contact");
    }

    @Then("contact {int} is present on the contacts list")
    public void new_contact_present_on_list(int index){
        assertTrue(stepDefinition.validateContactInList(contacts.get(index-1)),"New contact is not on the list");
    }

    @Then("contact {int} has contact {int} information")
    public void updated_contact_present_on_list(int newIndex){
        assertTrue(stepDefinition.validateContactInList(contacts.get(newIndex-1)),"Updated information is not on the list");
    }
    @Then("contact {int} is not present on the contacts list")
    public void new_contact_not_present_on_list(int index){
        assertFalse(stepDefinition.validateContactInList(contacts.get(index-1)),"Contact was eliminated but there's another contact with the same name");
    }
    @Then("user logs out of the system")
    public void user_logs_off(){
        assertEquals(stepDefinition.userLogsOff(),homePageTitle, "Home page didn't load correctly");

    }
}
