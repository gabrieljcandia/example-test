package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement headerProducts;

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public boolean isPage() {
        return isElementDisplayed(headerProducts);
    }
}