package pageobjects;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    protected static final Config CONFIG = ConfigFactory.load("configuration.conf");

    protected WebDriver driver;
    protected String basePage;
    protected int pause = CONFIG.getInt("pause");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitElementToBePresent(WebElement element){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(pause))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(WebDriverException.class);
        wait.until((Function<WebDriver, Boolean>) driver -> element.isDisplayed());
        return element;
    }

    protected WebElement waitElementToBePresent(By locator){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(pause))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until((Function<WebDriver, Boolean>) driver -> driver.findElement(locator).isDisplayed());
        return driver.findElement(locator);
    }

    protected boolean isElementDisplayed(Object element){
        //Check if element is displayed
        boolean isDisplayed = false;
        boolean classImplemented = false;
        try{
            if(element.getClass().getSimpleName().equals(WebElement.class.getSimpleName()) ||
                    element.getClass().getSuperclass().getSimpleName().equals(Proxy.class.getSimpleName())) {
                isDisplayed = waitElementToBePresent((WebElement) element).isDisplayed();
                classImplemented = true;
            }
            if(element.getClass().getSuperclass().getSimpleName().equals(By.class.getSimpleName())) {
                isDisplayed = waitElementToBePresent((By) element).isDisplayed();
                classImplemented = true;
            }
            if(element.getClass().getSimpleName().equals(RemoteWebElement.class.getSimpleName())) {
                isDisplayed = waitElementToBePresent((RemoteWebElement) element).isDisplayed();
                classImplemented = true;
            }
            if(!classImplemented){
                throw new NotImplementedException(String.format("The class %s has no implementation yet", element.getClass()));
            }
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException ex){
            return false;
        }

        return isDisplayed;
    }

}
