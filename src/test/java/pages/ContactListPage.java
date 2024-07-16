package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clickOnAddContact(){
        wait.until(webDriver -> addContactBtn.isEnabled());
        addContactBtn.click();
    }
    public Boolean findSpecificContact(String firstName, String lastName){
        boolean result = false;
        By xpathLocator = By.xpath("//*[text()='"+firstName+" "+lastName+"']");
        wait.until(driver -> contactsTable.isDisplayed());
        List<WebElement> rows = contactsTable.findElements(By.className("contactTableBodyRow"));
        for(WebElement row : rows) {
            if (row.findElement(xpathLocator).isDisplayed()){
                row.findElement(xpathLocator).click();
                result = true;
                break;
            }
        }
        logger.info("information submitted new page title "+driver.getTitle());
        return result;
    }
    public Boolean findSpecificContact(Contact contact){
        boolean result = false;
        try {
            By xpathLocator = By.xpath("//*[text()='" + contact.getFirstName() + " " + contact.getLastName() + "']");
            wait.until(driver -> contactsTable.isDisplayed());
            List<WebElement> rows = contactsTable.findElements(By.className("contactTableBodyRow"));
            for (WebElement row : rows) {
                if (row.findElement(xpathLocator).isDisplayed()) {
                    return true;
                }
            }
            logger.info("information submitted new page title " + driver.getTitle());
        } catch(NoSuchElementException e){
            logger.error("Contact not found");
            return result;
        }
        return result;
    }
}
