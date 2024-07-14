package pages;

import org.openqa.selenium.By;
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
        List<WebElement> rows = contactsTable.findElements(By.className("contactTableBodyRow"));
        for(WebElement row : rows) {
            if (row.findElement(xpathLocator).isDisplayed()){
                result = true;
            }
        }
        System.out.println("information submitted new page title "+driver.getTitle());
        return result;
    }
}
