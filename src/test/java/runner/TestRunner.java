package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue= {"steps"}
        , plugin = { "pretty"
        //"html:target/cucumber-reports"
        //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
        ,tags = ("@UpdateContact or @CreateContact or @DeleteContact")
        ,monochrome = true
)
public class TestRunner {

}
