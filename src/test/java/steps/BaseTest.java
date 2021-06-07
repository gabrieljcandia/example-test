package steps;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static final Config CONFIG = ConfigFactory.load("configuration.conf");
    protected static WebDriver driver;

    public static void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void closeDriver() {
        if(driver != null){
            driver.quit();
        }
    }

}
