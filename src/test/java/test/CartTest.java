package test;

import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.CartPage;
import util.VideoRecorder;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.testng.Assert.assertTrue;
import static util.PropertyFileReader.getProperty;

@Epic("Add item to cart")
@Feature("AddToCart")
public class CartTest extends BaseTest {
    private HomePage homePage;
    private CartPage cartPage;
    private VideoRecorder screenRecorder;
    private final String movieFolderPathString = "target/report-video/";

    @BeforeMethod
    public void setup(Method method) throws Exception {
        new LoginPage(driver).login(getProperty("username"),getProperty("password"));
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        new HomePage(driver).addToCartButtonClick();

        File movieFolder = new File(movieFolderPathString);
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }

        screenRecorder = new VideoRecorder(GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration(), method.getName(), movieFolder);
        screenRecorder.start();
    }

    @Test(description = "Verify that the page is loaded and title is present")
    @Severity(BLOCKER)
    @Description("Verify that title is present")
    @Story("Open cart page")
    public void testPageIsLoaded() {
        assertTrue(cartPage.checkTitle());
    }

    @Test(description = "Verify that it is possible to get back from cart page")
    @Severity(BLOCKER)
    @Description("Verify that back button is working")
    @Story("Back button is clicked")
    public void testBackToShop() {
        homePage.openCart();
        cartPage.clickBackToShop();
    }

    @AfterMethod
    public void teardown(Method method) throws Exception {
        screenRecorder.stop();
        File videoFile = new File(movieFolderPathString + method.getName() + ".avi");
        if (videoFile.exists()) {
            Allure.addAttachment("Video about test execution", FileUtils.openInputStream(videoFile));
        }
    }
}
