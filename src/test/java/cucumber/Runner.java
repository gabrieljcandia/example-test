package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import steps.BaseTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {
                "pretty"
        }
)
public class Runner {

    @BeforeClass
    public static void setup() {
        BaseTest.beforeSuite();
    }

    @AfterClass
    public static void end() {
        BaseTest.closeDriver();
    }

}