package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#user-name")
    private WebElement inputUsername;

    @FindBy(css = "#password")
    private WebElement inputPassword;

    @FindBy(css = "#login-button")
    private WebElement buttonLogin;

    @FindBy(css = "div[class*='error-message']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void goToPage(){
        super.basePage = CONFIG.getString("baseUrl");
        this.driver.navigate().to(basePage);
    }

    public boolean isPage(){
        return isElementDisplayed(inputUsername);
    }

    public void typeCredentials(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

    public boolean isLoginErrorDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public String getLoginErrorMessage(){
        return errorMessage.getText();
    }
}