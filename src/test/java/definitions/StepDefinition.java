package definitions;

import models.Contact;
import models.User;
import pages.*;
import steps.BaseTest;

public class StepDefinition extends BaseTest {
    LoginPage loginPage = new LoginPage(super.getDriver());
    ContactListPage contactListPage = new ContactListPage(super.getDriver());
    AddContactPage addContactPage = new AddContactPage(super.getDriver());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(super.getDriver());
    EditContactPage editContactPage = new EditContactPage(super.getDriver());

    public void login(User user){
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.submitLogin();
    }

    public void addContact(Contact contact){
        contactListPage.clickOnAddContact();
        addContactPage.enterFirstName(contact.getFirstName());
        addContactPage.enterlastName(contact.getLastName());
        addContactPage.submitAddition();
    }

    public Boolean searchContactByName(Contact contact){
        return contactListPage.findSpecificContact(contact.getFirstName(), contact.getLastName());
    }
    public void updateContact(Contact oldContact, Contact newContact){
        if(searchContactByName(oldContact)){
            contactDetailsPage.clickOnEditContact();
            editContactPage.enterNewFirstName(newContact.getFirstName());
            editContactPage.enterNewlastName(newContact.getLastName());
            editContactPage.submitEdition();
            contactDetailsPage.clickOnReturnToListButton();
        } else {
            logger.error("Contact not found");
        }
    }
    public Boolean validateNewContactInList(Contact contact){
        return contactListPage.findSpecificContact(contact);
    }
}
