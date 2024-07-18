package pages;

import net.serenitybdd.annotations.Step;
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

    @Step("Enter email")
    public void enterEmail(String email){
        emailField.sendKeys(email);
        logger.info("email entered {}",email);
    }
    @Step("Enter password")
    public void enterPassword(String password){
        passwordField.sendKeys(password);
        logger.info("password entered {}",password);
    }
    @Step("Submit data")
    public void submitLogin(){
        submitButton.click();
        logger.info("information submitted new page title {}",driver.getTitle());
    }
    @Step("Return home page title")
    public String waitForHomePageToLoad(){
        wait.until(driver -> emailField.isDisplayed());
        return driver.getTitle();
    }

}
