package pages;

import models.Contact;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListPage extends BasePage {
    public ContactListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "add-contact")
    private WebElement addContactBtn;

    @FindBy(id = "myTable")
    private WebElement contactsTable;

    @FindBy(id = "logout")
    WebElement logoutButton;

    @Step("Click on add contact")
    public void clickOnAddContact(){
        wait.until(webDriver -> addContactBtn.isEnabled());
        addContactBtn.click();
    }
    @Step("Find specific contact")
    public Boolean findSpecificContact(Contact contact, Boolean click){
        boolean result = false;
        By xpathLocator = By.xpath("//*[text()='"+contact.getFirstName()+" "+contact.getLastName()+"']");
        try{
            wait.until(driver -> contactsTable.isDisplayed());
            List<WebElement> rows = contactsTable.findElements(By.className("contactTableBodyRow"));
            for(WebElement row : rows) {
                if (row.findElement(xpathLocator).isDisplayed()){
                    if(click)
                        row.findElement(xpathLocator).click();
                    result = true;
                    break;
                }
                }
            logger.info("information submitted new page title "+driver.getTitle());
        } catch (NoSuchElementException | TimeoutException e){
            logger.error("Elements not found in page");
        }
        return result;
    }
    @Step()
    public void clickOnLogoutButton(){
        wait.until(driver -> logoutButton.isEnabled());
        logoutButton.click();
    }
}
