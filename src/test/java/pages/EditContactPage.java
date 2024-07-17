package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditContactPage extends BasePage {
    public EditContactPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "submit")
    private WebElement submitButton;

    public void enterNewFirstName(String firstName){
        wait.until(ExpectedConditions.attributeToBeNotEmpty(firstNameField,"value"));
        firstNameField.clear();
        wait.until(driver -> firstNameField.getText().isEmpty());
        firstNameField.sendKeys(firstName);
        logger.info("first name entered "+firstName);
    }
    public void enterNewlastName(String lastName){
        wait.until(driver -> firstNameField.isDisplayed());
        lastNameField.clear();
        wait.until(driver -> lastNameField.getText().isEmpty());
        lastNameField.sendKeys(lastName);
        logger.info("last name entered "+lastName);
    }
    public void submitEdition(){
        submitButton.click();
        logger.info("information submitted new page title "+driver.getTitle());
    }
}
