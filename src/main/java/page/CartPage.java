package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private final By titleLabel = By.xpath("//span[@class='title']");
    private final By removeButton = By.xpath("//button[contains(@id, 'remove')]");
    private final By checkoutButton = By.xpath("//button[contains(@id, 'checkout')]");
    private final By backButton = By.xpath("//button[contains(@id, 'continue')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkTitle() {
        waitUntilElementVisible(titleLabel);
        return getElement(titleLabel).isDisplayed();
    }

    public void clickBackToShop() {
        click(backButton);
    }


}
