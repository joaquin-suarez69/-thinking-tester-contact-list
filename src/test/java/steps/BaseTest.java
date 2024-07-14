package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {

    protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static final String baseURL = "https://thinking-tester-contact-list.herokuapp.com/";
    static WebDriver driver;
    //browsers: "chrome","firefox"
    static String browser = "chrome";
    @Before
    public static void setup(){
        switch (browser){
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
