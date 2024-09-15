package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[contains(@data-test, 'error')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        sendKeys(userNameInput, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public Boolean checkErrorMessagePresence() {
        return getElement(errorMessage).isDisplayed();
    }

    public void login(String username, String password) {
        setEmail(username);
        setPassword(password);
        clickSignIn();
    }
}
