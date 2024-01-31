import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ico-login")
    private WebElement loginTab;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(className = "login-button")
    private WebElement loginBtn;

    public void navigateToLogin() {
        loginTab.click();
    }

    public void setCredentials(String Email, String Password) {
        emailInput.sendKeys(Email);
        passwordInput.sendKeys(Password);
        loginBtn.click();

    }

    public void setCredentials(String Email) {
        emailInput.sendKeys(Email);
        loginBtn.click();
    }


}
