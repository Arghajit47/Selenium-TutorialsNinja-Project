package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By newCustomerContinueButton = By.xpath("//a[contains(text(),'Continue')]");
    By loginButton = By.cssSelector("input[type='submit']");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By forgottenPassword = By.cssSelector("div[class=\"form-group\"] > a");
    By myAccountsOptionsAfterLogin = By.xpath("(//ul[@class='dropdown-menu dropdown-menu-right']//a)");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateLoginPage() {
        driver.findElement(newCustomerContinueButton).isDisplayed();
        driver.findElement(email).isDisplayed();
        driver.findElement(password).isDisplayed();
        driver.findElement(loginButton).isDisplayed();
        driver.findElement(forgottenPassword).getAttribute("href").equals("https://tutorialsninja.com/demo/index.php?route=account/forgotten");
    }
    public void loginUser(String emailId, String Password) {
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(loginButton).click();
    }
    public void seesMyAccountOptionAfterLogin() {
        for (int i = 0; i < 5; i++) {
            driver.findElements(myAccountsOptionsAfterLogin).get(i).isDisplayed();
        }
    }
}
