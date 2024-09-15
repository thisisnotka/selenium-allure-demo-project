package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static WebDriver getNewDriverInstance(String browserName) {
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserName.toLowerCase()) {
            case "chrome":
                chromeOptions.addArguments("--disable-search-engine-choice-screen");
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case "chrome-headless":
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "firefox-headless":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(options);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
