package steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import models.Contact;
import models.User;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Slf4j
public class BaseTest {

    String baseURL = "";
    static WebDriver driver;
    Properties prop = new Properties();
    String browser = "";
    static String homePageTitle = "";
    static User user = User.getInstance();
    static List<Contact> contacts = new ArrayList<>();

    @Before
    public void setup(){
        try {
            loadProperties();
            loadContacts();
        } catch (IOException e){
            log.error("Error reading files");
            throw new RuntimeException(e);
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
        driver.quit();
    }
    private void loadProperties() throws IOException {
        InputStream input = Files.newInputStream(Paths.get("src/test/resources/config.properties"));
        prop.load(input);
        log.info("using account: "+prop.getProperty("user.email"));
        user.setEmail(prop.getProperty("user.email"));
        user.setPassword(prop.getProperty("user.password"));
        baseURL = prop.getProperty("base.url");
        browser = prop.getProperty("base.browser");
        homePageTitle = prop.getProperty("base.homepage.title");
    }
    private void loadContacts() throws IOException {
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
