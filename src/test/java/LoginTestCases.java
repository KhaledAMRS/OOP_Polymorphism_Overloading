import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCases extends TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        loadProjectDataProperties();   //If you don't call it -> you will get this error java.lang.NullPointerException: Cannot invoke "java.util.Properties.getProperty(String)" because "this.prop" is null

        this.driver = initializeBrowser(prop.getProperty("browser"));

        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1, testName = "validLogin")
    public void loginWithValidCredentials() throws IOException {
        LoginPage login = new LoginPage(driver);
        login.navigateToLogin();
        login.setCredentials("test@gmail.com", "password");
    }

    @Test(priority = 2, testName = "invalidLogin_EmailOnly")
    public void loginSetOnlyEmail() throws IOException {
        LoginPage login = new LoginPage(driver);
        login.navigateToLogin();
        login.setCredentials("test@gmail.com");

    }

    @AfterMethod
    public void closure() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
