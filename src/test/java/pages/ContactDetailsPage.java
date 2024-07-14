package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends BasePage {
    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "edit-contact")
    private WebElement editContactButton;

    @FindBy(id = "return")
    private WebElement returnToListButton;

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        logger.info("first name entered "+firstName);
    }
    public void enterlastName(String lastName){
        lastNameField.sendKeys(lastName);
        logger.info("last name entered "+lastName);
    }
    public void clickOnEditContact(){
        editContactButton.click();
        logger.info("Edit contact clicked "+driver.getTitle());
    }

    public void clickOnReturnToListButton(){
        wait.until(driver -> returnToListButton.isDisplayed());
        returnToListButton.click();
    }
}
