package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.driver.DriverFactory;

import static util.PropertyFileReader.getProperty;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        String browserType = System.getProperty("browserType", "chrome");
        driver = DriverFactory.getNewDriverInstance(browserType);
        driver.get(getProperty("url"));
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
