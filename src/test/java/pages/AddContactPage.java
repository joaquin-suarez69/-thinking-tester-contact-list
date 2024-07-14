package pages;

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
    @FindBy(id = "submit")
    private WebElement submitButton;

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        System.out.println("first name entered "+firstName);
    }
    public void enterlastName(String lastName){
        lastNameField.sendKeys(lastName);
        System.out.println("last name entered "+lastName);
    }
    public void submitAddition(){
        submitButton.click();
        System.out.println("information submitted new page title "+driver.getTitle());
    }
}
