package pages;

import net.serenitybdd.annotations.Step;
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

    @Step("Click on edit contact")
    public void clickOnEditContact(){
        editContactButton.click();
        logger.info("Edit contact clicked "+driver.getTitle());
    }

    @Step("Return to list")
    public void clickOnReturnToListButton(){
        wait.until(driver -> returnToListButton.isDisplayed());
        returnToListButton.click();
    }
    @Step("Click on delete contact")
    public void clickOnDeleteContact(){
        wait.until(driver -> deleteContactButton.isDisplayed());
        deleteContactButton.click();
        acceptAlert();
    }
    @Step("Accept alert")
    private void acceptAlert(){
        wait.until(driver -> driver.switchTo().alert());
        driver.switchTo().alert().accept();
    }
}
