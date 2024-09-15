package test;

import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import util.VideoRecorder;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static util.PropertyFileReader.getProperty;

@Epic("User management")
@Feature("Login")
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private VideoRecorder screenRecorder;
    private final String movieFolderPathString = "target/report-video/";

    @BeforeMethod
    public void setup(Method method) throws Exception {
        File movieFolder = new File(movieFolderPathString);
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }

        screenRecorder = new VideoRecorder(method.getName(), movieFolder);
        screenRecorder.start();

        loginPage = new LoginPage(driver);
    }

    @Test(description = "Verify that a valid user can login to the application")
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    public void testValidLogin() {
        loginPage.login(getProperty("username"),getProperty("password"));
        assertEquals(new HomePage(driver).getHomePageTitle(), "Swag Labs");
    }

    @Test(description = "Verify that an invalid user cannot login to the application")
    @Severity(CRITICAL)
    @Description("Verify that an invalid user cannot login to the application")
    @Story("As a user I should be able to login to the application")
    public void testInvalidLogin() {
        loginPage.login("test", "test");
        assertTrue(loginPage.checkErrorMessagePresence());
    }

    @AfterMethod
    public void teardown(Method method) throws Exception {
        screenRecorder.stop();
        screenRecorder.attachVideoToAllure();
        driver.close();
    }
}
