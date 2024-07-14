package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public void enterEmail(String email){
        emailField.sendKeys(email);
        logger.info("email entered "+email);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
        logger.info("password entered "+password);
    }
    public void submitLogin(){
        submitButton.click();
        logger.info("information submitted new page title "+driver.getTitle());
    }
}
