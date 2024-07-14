package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features"
        ,glue= {"steps"}
        ,plugin = { "pretty", "html:target/cucumber-report.html" }
        ,tags = ("@UpdateContact or @CreateContact")
        ,monochrome = true
)
public class TestRunner {

}
