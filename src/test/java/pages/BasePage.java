package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage extends PageObject {

    protected static Logger logger = LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;
    String title;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        title = driver.getTitle();
        PageFactory.initElements(driver,this);
    }
}
