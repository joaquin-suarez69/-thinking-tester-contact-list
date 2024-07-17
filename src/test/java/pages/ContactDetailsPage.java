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
    @FindBy(id = "delete")
    private WebElement deleteContactButton;

    public void clickOnEditContact(){
        editContactButton.click();
        logger.info("Edit contact clicked "+driver.getTitle());
    }

    public void clickOnReturnToListButton(){
        wait.until(driver -> returnToListButton.isDisplayed());
        returnToListButton.click();
    }
    public void clickOnDeleteContact(){
        wait.until(driver -> deleteContactButton.isDisplayed());
        deleteContactButton.click();
        acceptAlert();
    }
    private void acceptAlert(){
        wait.until(driver -> driver.switchTo().alert());
        driver.switchTo().alert().accept();
    }
}
