package runner.herokuapp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/CucumberString.feature",
        glue = "steps/com/stringSteps",
        dryRun = false
)

public class StringRunner {
}
