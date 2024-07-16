package steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.Contact;
import models.User;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static String baseURL = "";
    static WebDriver driver;
    static Properties prop = new Properties();
    //browsers: "chrome","firefox"
    static String browser = "";
    static User user = User.getInstance();
    static List<Contact> contacts = new ArrayList<>();

    @Before
    public static void setup(){
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(input);
            logger.info("using account: "+prop.getProperty("user.email"));
            user.setEmail(prop.getProperty("user.email"));
            user.setPassword(prop.getProperty("user.password"));
            baseURL = prop.getProperty("base.url");
            browser = prop.getProperty("base.browser");
            loadContacts();
        } catch (IOException ex) {
            logger.error("setup failed to read files");
            ex.printStackTrace();
        }
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
        //driver.close();
        driver.quit();
    }
    private static void loadContacts() throws IOException {
        String filePath = "src/test/resources/users.json";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonString.append(line);
        }
        reader.close();
        String jsonStringFinal = jsonString.toString();
        ObjectMapper mapper = new ObjectMapper();
        contacts = mapper.readValue(jsonStringFinal, new TypeReference<List<Contact>>() {});
    }
    public WebDriver getDriver(){
        return driver;
    }
}
