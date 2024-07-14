package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        System.out.println("email entered "+email);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
        System.out.println("password entered "+password);
    }
    public void submitLogin(){
        submitButton.click();
        System.out.println("information submitted new page title "+driver.getTitle());
    }
}
