package definitions;

import models.Contact;
import models.User;
import pages.AddContactPage;
import pages.ContactListPage;
import pages.LoginPage;
import steps.BaseTest;

public class StepDefinition extends BaseTest {
    LoginPage loginPage = new LoginPage(super.getDriver());
    ContactListPage contactListPage = new ContactListPage(super.getDriver());
    AddContactPage addContactPage = new AddContactPage(super.getDriver());

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
}
