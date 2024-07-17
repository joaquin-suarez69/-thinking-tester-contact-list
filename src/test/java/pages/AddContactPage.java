package pages;

import models.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactPage extends BasePage {
    public AddContactPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "birthdate")
    private WebElement birthDateField;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "street1")
    private WebElement addressOneField;
    @FindBy(id = "street2")
    private WebElement addressTwoField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "stateProvince")
    private WebElement stateField;
    @FindBy(id = "postalCode")
    private WebElement postalCodeField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        logger.info("information entered "+firstName);
    }
    public void enterlastName(String lastName){
        lastNameField.sendKeys(lastName);
        logger.info("information entered "+lastName);
    }
    public void enterOptionalContactInformation(Contact contact){
        birthDateField.sendKeys(contact.getDateOfBirth());
        emailField.sendKeys(contact.getEmail());
        phoneField.sendKeys(String.valueOf(contact.getPhone()));
        addressOneField.sendKeys(contact.getAddressOne());
        addressTwoField.sendKeys(contact.getAddressTwo());
        cityField.sendKeys(contact.getCity());
        stateField.sendKeys(contact.getState());
        postalCodeField.sendKeys(String.valueOf(contact.getPostalCode()));
        countryField.sendKeys(contact.getCountry());
        logger.info("optional contact information entered");
    }
    public void submitAddition(){
        submitButton.click();
        logger.info("information submitted new page title "+driver.getTitle());
    }
}
