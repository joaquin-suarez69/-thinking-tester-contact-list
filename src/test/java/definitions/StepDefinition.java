package definitions;


import lombok.extern.slf4j.Slf4j;
import models.Contact;
import models.User;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import pages.ContactDetailsPage;
import pages.ContactListPage;
import pages.EditableFieldsContactPage;
import pages.LoginPage;
import steps.BaseTest;

@Slf4j
public class StepDefinition extends BaseTest {
    @Steps
    LoginPage loginPage = new LoginPage(super.getDriver());
    @Steps
    ContactListPage contactListPage = new ContactListPage(super.getDriver());
    @Steps
    EditableFieldsContactPage editableFieldsContactPage = new EditableFieldsContactPage(super.getDriver());
    @Steps
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(super.getDriver());

    @Step("User logs on the system")
    public void login(User user){
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.submitLogin();
    }

    @Step("User adds a contact")
    public void addContact(Contact contact){
        contactListPage.clickOnAddContact();
        editableFieldsContactPage.enterFirstName(contact.getFirstName());
        editableFieldsContactPage.enterLastName(contact.getLastName());
        editableFieldsContactPage.enterOptionalContactInformation(contact);
        editableFieldsContactPage.clickOnSubmit();
    }
    @Step("User searches a contact by name")
    public Boolean searchContactAndClick(Contact contact, Boolean click){
        return contactListPage.findSpecificContact(contact, click);
    }
    @Step("User updates a contact information")
    public void updateContact(Contact oldContact, Contact newContact){
        if(searchContactAndClick(oldContact, true)){
            contactDetailsPage.clickOnEditContact();
            editableFieldsContactPage.enterNewFirstName(newContact.getFirstName());
            editableFieldsContactPage.enterNewlastName(newContact.getLastName());
            editableFieldsContactPage.enterOptionalContactInformation(newContact);
            editableFieldsContactPage.clickOnSubmit();
            contactDetailsPage.clickOnReturnToListButton();
        } else {
            log.error("Contact not found");
        }
    }
    @Step("User deletes a contact")
    public Boolean deleteContact(Contact contact){
        if(searchContactAndClick(contact, true)){
            contactDetailsPage.clickOnDeleteContact();
            return true;
        } else {
            log.error("Contact not found");
            return false;
        }
    }
    @Step("User validates if contact is on the list")
    public Boolean validateContactInList(Contact contact){
        return contactListPage.findSpecificContact(contact, false);
    }
    @Step("User logs off the system")
    public String userLogsOff(){
        contactListPage.clickOnLogoutButton();
        return loginPage.waitForHomePageToLoad();

    }
}
