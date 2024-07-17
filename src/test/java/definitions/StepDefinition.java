package definitions;



import models.Contact;
import models.User;
import net.serenitybdd.annotations.Step;
import pages.*;
import steps.BaseTest;

public class StepDefinition extends BaseTest {
    LoginPage loginPage = new LoginPage(super.getDriver());
    ContactListPage contactListPage = new ContactListPage(super.getDriver());
    AddContactPage addContactPage = new AddContactPage(super.getDriver());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(super.getDriver());
    EditContactPage editContactPage = new EditContactPage(super.getDriver());
    @Step("User logs on the system")
    public void login(User user){
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.submitLogin();
    }

    @Step("User adds a contact")
    public void addContact(Contact contact){
        contactListPage.clickOnAddContact();
        addContactPage.enterFirstName(contact.getFirstName());
        addContactPage.enterlastName(contact.getLastName());
        addContactPage.enterOptionalContactInformation(contact);
        addContactPage.submitAddition();
    }
    @Step("User searchs a contact by name")
    public Boolean searchContactByName(Contact contact){
        return contactListPage.findSpecificContact(contact.getFirstName(), contact.getLastName());
    }
    @Step("User updates a contact information")
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
    @Step("User deletes a contact")
    public void deleteContact(Contact contact){
        if(searchContactByName(contact)){
            contactDetailsPage.clickOnDeleteContact();
        } else {
            logger.error("Contact not found");
        }
    }
    @Step("User validates if new contact is on the list")
    public Boolean validateNewContactInList(Contact contact){
        return contactListPage.findSpecificContact(contact);
    }

    public Contact createContact(String firstName, String lastName){
        return Contact.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
    public Contact createContact(String firstName, String lastName, String dateOfBirth, String email, String phone, String addressOne, String addressTwo, String city, String state, String postalCode, String country){
        return Contact.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .email(email)
                .phone(phone)
                .addressOne(addressOne)
                .addressTwo(addressTwo)
                .city(city)
                .state(state)
                .postalCode(postalCode)
                .country(country)
                .build();
    }
}
