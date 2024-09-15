package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By titleLabel = By.xpath("//div[@class='app_logo']");
    private final By addToCartBackPackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By openCartButton = By.id("shopping_cart_container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomePageTitle() {
        return getElement(titleLabel).getText();
    }

    public void addToCartButtonClick() {
        click(addToCartBackPackButton);
    }

    public void openCart() {
        click(openCartButton);
    }

}
