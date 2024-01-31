import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public Properties prop;

    public WebDriver initializeBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }

    public void loadProjectDataProperties()
    {
    prop = new Properties();

    String projectPath = System.getProperty("user.dir");

        File file = new File(projectPath + "/src/main/resources/ProjectData.properties");

        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        }
        catch (Throwable t)
        {
            System.out.println(t.getMessage());
        }

    }

}
