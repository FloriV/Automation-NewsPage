package testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources"
        , glue = {"steps"}
)
// Before running tests add ChromeDriver to path system environment variable
public class NewsPageRunner {
    // Run this
}
