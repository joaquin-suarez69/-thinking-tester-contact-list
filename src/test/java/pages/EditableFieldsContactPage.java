package pages;

import models.Contact;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditableFieldsContactPage extends BasePage {
    public EditableFieldsContactPage(WebDriver driver) {
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

    @Step("Enter first name information")
    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        logger.info("information entered "+firstName);
    }
    @Step("Enter last name information")
    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
        logger.info("information entered "+lastName);
    }
    @Step("Enter new first name")
    public void enterNewFirstName(String firstName){
        wait.until(ExpectedConditions.attributeToBeNotEmpty(firstNameField,"value"));
        firstNameField.clear();
        wait.until(driver -> firstNameField.getText().isEmpty());
        firstNameField.sendKeys(firstName);
        logger.info("first name entered "+firstName);
    }
    @Step("Enter new last name")
    public void enterNewlastName(String lastName){
        wait.until(driver -> firstNameField.isDisplayed());
        lastNameField.clear();
        wait.until(driver -> lastNameField.getText().isEmpty());
        lastNameField.sendKeys(lastName);
        logger.info("last name entered "+lastName);
    }
    @Step("Enter optional information")
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
    @Step("Submit data")
    public void clickOnSubmit(){
        submitButton.click();
        logger.info("information submitted new page title "+driver.getTitle());
    }
}
