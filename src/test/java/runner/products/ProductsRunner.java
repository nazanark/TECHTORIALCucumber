package runner.products;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-html-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/com.products/productsScenario.feature",
        glue = "steps",
        dryRun = false,
        tags = "@products"
)

public class ProductsRunner {

}
