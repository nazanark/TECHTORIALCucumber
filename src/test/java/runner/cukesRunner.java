package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.weborder","src/test/resources/com.ebay","src/test/resources/com.weborder/order.feature"},
        glue = "steps",
        dryRun = false
)
public class cukesRunner {

}
